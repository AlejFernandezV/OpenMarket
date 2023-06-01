/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.infra.tcpip;

import co.edu.unicauca.openmarket.server.access.category.CategoryRepositoryImplArrays;
import co.edu.unicauca.openmarket.server.access.product.ProductRepositoryImplArrays;
import co.edu.unicauca.openmarket.server.access.user.UserRepositoryImplArrays;
import co.edu.unicauca.openmarket.server.domain.services.CategoryService;
import co.edu.unicauca.openmarket.server.domain.services.ProductService;
import co.edu.unicauca.openmarket.server.domain.services.UserService;
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
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el puerto de escucha");
        int port = teclado.nextInt();
        ServerSocketMultiThread myServer = new ServerSocketMultiThread(port);
        OpenMarketHandler myHandler = new OpenMarketHandler();
        myHandler.setServiceP(new ProductService(new ProductRepositoryImplArrays()));
        myHandler.setServiceC(new CategoryService(new CategoryRepositoryImplArrays()));
        myHandler.setServiceU(new UserService(new UserRepositoryImplArrays()));
        myServer.setServerHandler(myHandler);
        myServer.startServer();
        myHandler.getServiceP().addObservador(myHandler);
    }
}
