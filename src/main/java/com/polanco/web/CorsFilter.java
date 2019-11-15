/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polanco.web;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.*;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
/**
 *
 * @author POLANCO
 */
@Provider
public class CorsFilter implements ContainerResponseFilter{
    
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin","*");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers", "origin, X-Requested-with, Content-Type, Accept, Authorization");
        headers.add("Access-Control-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
    
}
