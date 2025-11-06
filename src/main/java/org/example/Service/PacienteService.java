package org.example.Service;

import org.example.DAO.PacienteDAO;
import org.example.Model.Paciente;
import java.util.List;

public class PacienteService {
    private PacienteDAO dao = new PacienteDAO();

    public List<Paciente> listarTodos() throws Exception {
        return dao.readAll();
    }

    public Paciente buscarPorId(int id) throws Exception {
        for (Paciente p : dao.readAll()) {
            if (p.getIdPaciente() == id) return p;
        }
        return null;
    }

    public void cadastrar(Paciente paciente) throws Exception {
        dao.create(paciente);
    }

    public void atualizar(Paciente paciente) throws Exception {
        dao.update(paciente);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
