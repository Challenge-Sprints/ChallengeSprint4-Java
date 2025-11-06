package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.Agendamento;
import org.example.Service.AgendamentoService;
import java.util.List;

@Path("/agendamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendamentoResource {
    private AgendamentoService service = new AgendamentoService();

    @GET
    public Response listarTodos() {
        try {
            return Response.ok(service.listarTodos()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        try {
            Agendamento a = service.buscarPorId(id);
            return a != null ? Response.ok(a).build() : Response.status(404).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Agendamento agendamento) {
        try {
            service.cadastrar(agendamento);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Agendamento agendamento) {
        try {
            agendamento.setIdAgendamento(id);
            service.atualizar(agendamento);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE @Path("/{id}")
    public Response excluir(@PathParam("id") int id) {
        try {
            service.excluir(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
