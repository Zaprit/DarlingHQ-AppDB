/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.darlinghq.appdb;

import java.util.Properties;
import org.eclipse.jetty.server.Server;

/**
 *
 * @author henry
 */
public class ServerMain {
    public static Properties config = new Properties();
    public static Server createServer(int port) {
        Server server = new Server(port);
        server.setHandler(new MainHandler());
        return server;
    }

    public static void main(String[] args) {
        config.setProperty("web_port", "8080");
        config.setProperty("db_port", "5432");
        config.setProperty("db_user", "appdb");
        config.setProperty("db_pass", "appdb");
        config.setProperty("db_driver", "postgresql");
        config.setProperty("db_name", "appdb");
        
        try {
            Server server = createServer(Integer.parseInt(config.getProperty("port")));
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException("Failed To Start Server");
        }
    }
}
