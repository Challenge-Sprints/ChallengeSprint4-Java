package org.example.Service;

import org.example.DAO.AgendamentoDAO;
import org.example.Model.Agendamento;
import java.util.List;

public class AgendamentoService {
    private AgendamentoDAO dao = new AgendamentoDAO();

    public List<Agendamento> listarTodos() throws Exception {
        return dao.readAll();
    }

    public Agendamento buscarPorId(int id) throws Exception {
        for (Agendamento a : dao.readAll()) {
            if (a.getIdAgendamento() == id) return a;
        }
        return null;
    }

    public void cadastrar(Agendamento agendamento) throws Exception {
        dao.create(agendamento);
    }

    public void atualizar(Agendamento agendamento) throws Exception {
        dao.update(agendamento);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
