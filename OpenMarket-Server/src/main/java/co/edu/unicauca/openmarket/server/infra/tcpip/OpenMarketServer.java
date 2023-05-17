/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.infra.tcpip;

import co.edu.unicauca.openmarket.server.access.CategoryRepositoryImplArrays;
import co.edu.unicauca.openmarket.server.access.ProductRepositoryImplArrays;
import co.edu.unicauca.openmarket.server.domain.services.CategoryService;
import co.edu.unicauca.openmarket.server.domain.services.ProductService;
import co.unicauca.strategyserver.infra.ServerSocketMultiThread;
import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class OpenMarketServer {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocketMultiThread myServer = new ServerSocketMultiThread(5000);
        OpenMarketHandler myHandler = new OpenMarketHandler();
        myHandler.setServiceP(new ProductService(new ProductRepositoryImplArrays()));
        myHandler.setServiceC(new CategoryService(new CategoryRepositoryImplArrays()));
        myServer.setServerHandler(myHandler);
        myServer.startServer();
        myHandler.getServiceP().addObservador(myHandler);
    }
}
