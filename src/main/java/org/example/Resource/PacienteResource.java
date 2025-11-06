package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.Paciente;
import org.example.Service.PacienteService;

@Path("/pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteResource {
    private PacienteService service = new PacienteService();

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
            Paciente p = service.buscarPorId(id);
            return p != null ? Response.ok(p).build() : Response.status(404).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Paciente paciente) {
        try {
            service.cadastrar(paciente);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Paciente paciente) {
        try {
            paciente.setIdPaciente(id);
            service.atualizar(paciente);
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
