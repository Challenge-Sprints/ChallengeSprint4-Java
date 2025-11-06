package org.example.DAO;

import org.example.Model.Agendamento;
import org.example.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    public void create(Agendamento a) throws SQLException {
        String sql = "INSERT INTO HC_AGENDAMENTO (id_agendamento, data_agendamento, horario, especialidade, status, HC_PACIENTE_id_paciente, HC_MEDICO_id_medico, HC_FEEDBACK_id_feedback) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getIdAgendamento());
            ps.setDate(2, a.getDataAgendamento());
            ps.setDate(3, a.getHorario());
            ps.setString(4, a.getEspecialidade());
            ps.setString(5, a.getStatus());
            ps.setInt(6, a.getIdPaciente());
            ps.setInt(7, a.getIdMedico());
            ps.setInt(8, a.getIdFeedback());
            ps.executeUpdate();
        }
    }

    public List<Agendamento> readAll() throws SQLException {
        List<Agendamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM HC_AGENDAMENTO";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Agendamento a = new Agendamento(
                        rs.getInt("id_agendamento"),
                        rs.getDate("data_agendamento"),
                        rs.getDate("horario"),
                        rs.getString("especialidade"),
                        rs.getString("status"),
                        rs.getInt("HC_PACIENTE_id_paciente"),
                        rs.getInt("HC_MEDICO_id_medico"),
                        rs.getInt("HC_FEEDBACK_id_feedback")
                );
                lista.add(a);
            }
        }
        return lista;
    }

    public void update(Agendamento a) throws SQLException {
        String sql = "UPDATE HC_AGENDAMENTO SET data_agendamento = ?, horario = ?, especialidade = ?, status = ?, HC_PACIENTE_id_paciente = ?, HC_MEDICO_id_medico = ?, HC_FEEDBACK_id_feedback = ? WHERE id_agendamento = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, a.getDataAgendamento());
            ps.setDate(2, a.getHorario());
            ps.setString(3, a.getEspecialidade());
            ps.setString(4, a.getStatus());
            ps.setInt(5, a.getIdPaciente());
            ps.setInt(6, a.getIdMedico());
            ps.setInt(7, a.getIdFeedback());
            ps.setInt(8, a.getIdAgendamento());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM HC_AGENDAMENTO WHERE id_agendamento = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Agendamento> buscarPorNome(String nome) throws SQLException {
        List<Agendamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM HC_AGENDAMENTO WHERE LOWER(especialidade) LIKE ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome.toLowerCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Agendamento a = new Agendamento(
                            rs.getInt("id_agendamento"),
                            rs.getDate("data_agendamento"),
                            rs.getDate("horario"),
                            rs.getString("especialidade"),
                            rs.getString("status"),
                            rs.getInt("HC_PACIENTE_id_paciente"),
                            rs.getInt("HC_MEDICO_id_medico"),
                            rs.getInt("HC_FEEDBACK_id_feedback")
                    );
                    lista.add(a);
                }
            }
        }
        return lista;
    }
}
