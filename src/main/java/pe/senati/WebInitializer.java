/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//WebInitializer -> Es el DispatcherServlet (la puerta de entrada al sistema)

package pe.senati;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    //método para uso de app web
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //método para indicar la clase de configuración
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    //método para leer URls por medio de las "/"
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }    
}
