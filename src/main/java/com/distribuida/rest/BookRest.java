package com.distribuida.rest;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/books")
public class BookRest {

    @Inject private BookService bookService;
    @Inject private DbConfig dbConfig;


    /** listar por ID **/
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer id){
        dbConfig.test();
        return bookService.findById(id);
    }


/**
 * get          /books/{id}     buscar
 * get          /books          listar todos
 * post         /books          insertar
 * put/patch    books/{id}      actualizar
 * delete       books/{id}      eliminar
 * **/


    /** listar todos **/
 @GET
 @Produces(MediaType.APPLICATION_JSON)
     public List <Book> findAll(){
     return bookService.findAll();
}


    /** Inserta libro **/
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void insert(Book book){
    bookService.insert(book);
}

    /** Actualizar libro **/
@PUT
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void update(@PathParam("id") Integer id,Book book){

    bookService.update(id,book);
}


    /** Eliminar libro **/
@DELETE
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void delete( @PathParam("id") Integer id){
    bookService.delete(id);
}
}
