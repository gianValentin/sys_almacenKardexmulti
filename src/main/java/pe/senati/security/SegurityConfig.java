/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SegurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    @Qualifier("customSuccessHandler")
    private SimpleUrlAuthenticationSuccessHandler successHandler;
        
    @Autowired
    @Qualifier("userServiceDetailsImpl")
    private UserDetailsService userDetailsService;
    
    //metodo para configurar metodos en usuarios
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        
        auth.authenticationProvider(daoAuthenticationProvider());
        
    }
    //Metodo para configurar los permisos URLs según el rol de usuario
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/index","/login").anonymous()
                .antMatchers("/home/**","/venta/**").access("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/presentacionCrud/**","/clienteCrud/**","/reportVenta/**","/categoriaCrud/**","/productoCrud/**","/userCrud/**").access("hasRole('SUPERADMIN') or hasRole('ADMIN')");
        //se usara un login personalizado
        http.authorizeRequests().and().formLogin().loginPage("/login").usernameParameter("txtUsername").passwordParameter("txtPassword").successHandler(successHandler);
        
        //se configuracion el value"/access_denied"
        //para ka pagina de error para accesos denegados
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/access_denied");
        //se habilita la proteccion de ataques maliciosos
        http.authorizeRequests().and().csrf();        
        
    }
   
    //bean para cifrar contraseña
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    //bean para definir los proveedores
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
