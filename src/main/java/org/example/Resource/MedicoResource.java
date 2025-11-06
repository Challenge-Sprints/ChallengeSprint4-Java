package org.example.Service;

import org.example.DAO.MedicoDAO;
import org.example.Model.Medico;
import java.util.List;

public class MedicoResource {
    private MedicoDAO dao = new MedicoDAO();

    public List<Medico> listarTodos() throws Exception {
        return dao.readAll();
    }

    public Medico buscarPorId(int id) throws Exception {
        for (Medico m : dao.readAll()) {
            if (m.getIdMedico() == id) return m;
        }
        return null;
    }

    public void cadastrar(Medico medico) throws Exception {
        dao.create(medico);
    }

    public void atualizar(Medico medico) throws Exception {
        dao.update(medico);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
