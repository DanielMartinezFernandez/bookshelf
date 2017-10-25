package com.test.rest;

import com.test.dao.BookDAO;
import com.test.data.Book;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/book")
@Produces("application/json;charset=utf-8")
@Api(value = "book", description = "Book test service")
public class BookResource {

    private BookDAO bookDAO;

    public BookResource() {
        this.bookDAO = new BookDAO();
    }

    @GET
    @ApiOperation("list test objects")
    public Response list() {
        return Response.ok(this.bookDAO.list()).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation("get test object")
    public Response get(@PathParam("id") Long id) {
        Book book = this.bookDAO.get(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(book).build();
    }

    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("save test object")
    public Response save(Book book) {
        this.bookDAO.save(book);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("delete test object")
    public Response delete(@PathParam("id") Long id) {
    	Book book = this.bookDAO.get(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.bookDAO.delete(book);
        return Response.ok().build();
    }
}
