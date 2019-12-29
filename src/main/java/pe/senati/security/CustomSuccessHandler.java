/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;



@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    private RedirectStrategy redirectStrategy =new DefaultRedirectStrategy();
    
    public CustomSuccessHandler() {
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //url destino
        String TargetURL=this.determineTargetUrl(authentication);    
        //redireccionar a la url destino
        redirectStrategy.sendRedirect(request, response, TargetURL);     
    }

    
    protected String determineTargetUrl(Authentication authentication) {
       String url;
       //colección de (vacio)
       List<String> roles=new ArrayList();
       
      for(GrantedAuthority ga:authentication.getAuthorities()){
          roles.add(ga.getAuthority());
      } 
      if(roles.contains("ROLE_SUPERADMIN"))
          url="/home";
      else if(roles.contains("ROLE_ADMIN"))
          url="/home";
      else if(roles.contains("ROLE_USER"))
          url="/home";
      else 
        url="/access_denied";
      
      return url;
    }
    
}
