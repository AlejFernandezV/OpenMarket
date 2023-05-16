/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.unicauca.edu.co.openmarket.loadbalancer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class OpenMarketLoadBalancer {

    private List<String> serverAddresses;
    private int currentServerIndex;

    public OpenMarketLoadBalancer(List<String> serverAddresses) {
        this.serverAddresses = serverAddresses;
        this.currentServerIndex = 0;
    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Load balancer started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from client: " + clientSocket.getInetAddress().getHostAddress());

                String serverAddress = getNextServerAddress();
                System.out.println("Routing request to server: " + serverAddress);

                // Enviar la solicitud del cliente al servidor
                Socket serverSocket = new Socket(serverAddress, 8080);
                forwardRequest(clientSocket.getInputStream(), serverSocket.getOutputStream());

                // Enviar la respuesta del servidor al cliente
                forwardResponse(serverSocket.getInputStream(), clientSocket.getOutputStream());

                clientSocket.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized String getNextServerAddress() {
        String serverAddress = serverAddresses.get(currentServerIndex);
        currentServerIndex = (currentServerIndex + 1) % serverAddresses.size();
        return serverAddress;
    }

    private void forwardRequest(InputStream clientInput, OutputStream serverOutput) throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = clientInput.read(buffer)) != -1) {
            serverOutput.write(buffer, 0, bytesRead);
        }
        serverOutput.flush();
    }

    private void forwardResponse(InputStream serverInput, OutputStream clientOutput) throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = serverInput.read(buffer)) != -1) {
            clientOutput.write(buffer, 0, bytesRead);
        }
        clientOutput.flush();
    }

    public static void main(String[] args) {
        List<String> serverAddresses = new ArrayList<>();
        serverAddresses.add("localhost"); // Dirección del primer servidor
        serverAddresses.add("127.0.0.1"); // Dirección del segundo servidor
        // Agrega más direcciones de servidor según sea necesario

        OpenMarketLoadBalancer loadBalancer = new OpenMarketLoadBalancer(serverAddresses);
        loadBalancer.start(8080); // Puerto del balanceador de carga
    }
}
