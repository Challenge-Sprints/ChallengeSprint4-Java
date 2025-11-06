package org.example.Service;

import org.example.DAO.IntegracaoChatbotDAO;
import org.example.Model.IntegracaoChatbot;
import java.util.List;

public class IntegracaoChatbotService {
    private IntegracaoChatbotDAO dao = new IntegracaoChatbotDAO();

    public List<IntegracaoChatbot> listarTodos() throws Exception {
        return dao.readAll();
    }

    public IntegracaoChatbot buscarPorId(int id) throws Exception {
        for (IntegracaoChatbot i : dao.readAll()) {
            if (i.getIdIntegracao() == id) return i;
        }
        return null;
    }

    public void cadastrar(IntegracaoChatbot integracao) throws Exception {
        dao.create(integracao);
    }

    public void atualizar(IntegracaoChatbot integracao) throws Exception {
        dao.update(integracao);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
