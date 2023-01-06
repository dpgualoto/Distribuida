package com.distribuida.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import java.sql.Connection;


/**
 * Componentes CDI**/
@ApplicationScoped
public class DbConfig {
    @Inject
    @ConfigProperty(name ="db.user")
    String dbUser;
    @Inject
    @ConfigProperty(name="db.password")
    String dbPasswd;

    @Inject
    @ConfigProperty(name="db.url")
    String dbUrl;

     Jdbi jdbi3=null;

    public static Connection conexion;

    @PostConstruct
    public void init()  {
        System.out.println(" ********** Post contruct **********");
        System.out.println(dbUser);
        System.out.println(dbPasswd);
        System.out.println(dbUrl);

    }
    @ApplicationScoped
    @Produces
    public Handle conexion(){
        jdbi3 = jdbi3.create(dbUrl,dbUser,dbPasswd);
        return jdbi3.open();
    }
    public void test(){

    }
}
