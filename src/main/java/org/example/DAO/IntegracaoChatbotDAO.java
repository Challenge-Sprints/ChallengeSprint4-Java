package org.example.DAO;

import org.example.Model.IntegracaoChatbot;
import org.example.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IntegracaoChatbotDAO {

    public void create(IntegracaoChatbot i) throws SQLException {
        String sql = "INSERT INTO HC_INTERACAO_CHATBOT (id_interacao, data_interecao, intencao, resposta, tempo_resposta, canal, status, HC_FAQ_id_faq, HC_PACIENTE_id_paciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, i.getIdInteracao());
            ps.setDate(2, i.getDataInterecao());
            ps.setString(3, i.getIntencao());
            ps.setString(4, i.getResposta());
            ps.setDate(5, i.getTempoResposta());
            ps.setString(6, i.getCanal());
            ps.setString(7, i.getStatus());
            ps.setInt(8, i.getIdFaq());
            ps.setInt(9, i.getIdPaciente());
            ps.executeUpdate();
        }
    }

    public List<IntegracaoChatbot> readAll() throws SQLException {
        List<IntegracaoChatbot> lista = new ArrayList<>();
        String sql = "SELECT * FROM HC_INTERACAO_CHATBOT";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                IntegracaoChatbot i = new IntegracaoChatbot(
                        rs.getInt("id_interacao"),
                        rs.getDate("data_interecao"),
                        rs.getString("intencao"),
                        rs.getString("resposta"),
                        rs.getDate("tempo_resposta"),
                        rs.getString("canal"),
                        rs.getString("status"),
                        rs.getInt("HC_FAQ_id_faq"),
                        rs.getInt("HC_PACIENTE_id_paciente")
                );
                lista.add(i);
            }
        }
        return lista;
    }

    public void update(IntegracaoChatbot i) throws SQLException {
        String sql = "UPDATE HC_INTERACAO_CHATBOT SET data_interecao = ?, intencao = ?, resposta = ?, tempo_resposta = ?, canal = ?, status = ?, HC_FAQ_id_faq = ?, HC_PACIENTE_id_paciente = ? WHERE id_interacao = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, i.getDataInterecao());
            ps.setString(2, i.getIntencao());
            ps.setString(3, i.getResposta());
            ps.setDate(4, i.getTempoResposta());
            ps.setString(5, i.getCanal());
            ps.setString(6, i.getStatus());
            ps.setInt(7, i.getIdFaq());
            ps.setInt(8, i.getIdPaciente());
            ps.setInt(9, i.getIdInteracao());
            ps.executeUpdate();
        }
    }

    public void delete(int idInteracao) throws SQLException {
        String sql = "DELETE FROM HC_INTERACAO_CHATBOT WHERE id_interacao = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idInteracao);
            ps.executeUpdate();
        }
    }
}
