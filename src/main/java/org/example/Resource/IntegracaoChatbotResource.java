package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.IntegracaoChatbot;
import org.example.Service.IntegracaoChatbotService;

@Path("/integracoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IntegracaoChatbotResource {
    private IntegracaoChatbotService service = new IntegracaoChatbotService();

    @GET
    public Response listarTodos() {
        try {
            return Response.ok(service.listarTodos()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        try {
            IntegracaoChatbot integracao = service.buscarPorId(id);
            return integracao != null ? Response.ok(integracao).build() : Response.status(404).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(IntegracaoChatbot integracao) {
        try {
            service.cadastrar(integracao);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, IntegracaoChatbot integracao) {
        try {
            integracao.setIdIntegracao(id);
            service.atualizar(integracao);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") int id) {
        try {
            service.excluir(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
