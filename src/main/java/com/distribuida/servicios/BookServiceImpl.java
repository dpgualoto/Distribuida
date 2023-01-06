package com.distribuida.servicios;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Handle;


import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class BookServiceImpl implements BookService{
    private static final String INSERT_ORDER_QUERY = "INSERT INTO books (isbn,title,author,price) VALUES (:isbn,:title,:author,:price)";
    private static final String SELECT_ORDERS_QUERY = "SELECT * FROM books";
    private static final String UPDATE_ORDERS_QUERY = "UPDATE books SET isbn=:isbn, title=:title, author=:author,price=:price WHERE id=:id";
    @Inject
    DbConfig dbConfig;

    private List<Book> lista= new ArrayList<>();

    /** Buscar por ID **/
    @Override
    public Book findById(Integer id) {
        Book ret = new Book();
        try {
            Handle handle= dbConfig.conexion();
            ret= handle.createQuery("Select * from books where id = ?;").bind(0,id).mapToBean(Book.class).findOnly();
            handle.close();

        }catch (Exception e){

        }
        return ret;
    }

    /** Buscar todos **/
    @Override
    public List<Book> findAll() {
        List <Book> listarTodo = null;
        try {
            Handle handle= dbConfig.conexion();
            listarTodo= handle.createQuery(SELECT_ORDERS_QUERY)
                    .mapToBean(Book.class)
                    .list();
            handle.close();
        }catch (Exception e){

        }
        return listarTodo;
    }

    /** Insertar **/
    @Override
    public void insert(Book book) {
        Handle jdbi3 = dbConfig.conexion();
        jdbi3.createUpdate(INSERT_ORDER_QUERY)
                .bind("isbn",book.getIsbn())
                .bind("title",book.getTitle())
                .bind("author",book.getAuthor())
                .bind("price",book.getPrice()).execute();
    }

    /** Actualizar **/
    @Override
    public void update(Integer id,Book book) {
        Handle jdbi3 = dbConfig.conexion();
        jdbi3.createUpdate(UPDATE_ORDERS_QUERY)
                .bind("id",id)
                .bind("isbn",book.getIsbn())
                .bind("title",book.getTitle())
                .bind("author",book.getAuthor())
                .bind("price",book.getPrice()).execute();

    }
    /** Eliminar **/
    @Override
    public void delete(Integer id) {
        Book ret = new Book();
        try {
            Handle jdbi3 = dbConfig.conexion();
            ret=jdbi3.createQuery("DELETE FROM books WHERE id= ?;").bind(0,id).mapToBean(Book.class).findOnly();

        }catch (Exception e){

        }

    }

}
