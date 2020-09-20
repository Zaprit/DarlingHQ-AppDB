/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.darlinghq.appdb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 *
 * @author henry
 */
public class MainHandler extends AbstractHandler{

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getMethod().contentEquals("GET")){
            switch(target){
                case "/":
                    response.setContentType("text/html; charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().println("Hello World");
                    baseRequest.setHandled(true);
                case "/addentry":
                    ArrayList<String> query = Arrays.asList(request.getQueryString().split("&"));
            }        
        }
    }
    
    
}
