package org.example.DAO;

import org.example.Model.Medico;
import org.example.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public void create(Medico m) throws SQLException {
        String sql = "INSERT INTO HC_MEDICO (id_medico, nome_medico, crm, especialidade, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, m.getIdMedico());
            ps.setString(2, m.getNomeMedico());
            ps.setString(3, m.getCrm());
            ps.setString(4, m.getEspecialidade());
            ps.setString(5, m.getEmail());
            ps.setString(6, m.getTelefone());
            ps.executeUpdate();
        }
    }

    public List<Medico> readAll() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM HC_MEDICO";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medico m = new Medico(
                        rs.getInt("id_medico"),
                        rs.getString("nome_medico"),
                        rs.getString("crm"),
                        rs.getString("especialidade"),
                        rs.getString("email"),
                        rs.getString("telefone")
                );
                lista.add(m);
            }
        }
        return lista;
    }

    public void update(Medico m) throws SQLException {
        String sql = "UPDATE HC_MEDICO SET nome_medico = ?, crm = ?, especialidade = ?, email = ?, telefone = ? WHERE id_medico = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNomeMedico());
            ps.setString(2, m.getCrm());
            ps.setString(3, m.getEspecialidade());
            ps.setString(4, m.getEmail());
            ps.setString(5, m.getTelefone());
            ps.setInt(6, m.getIdMedico());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM HC_MEDICO WHERE id_medico = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Medico> buscarPorNome(String nome) throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM HC_MEDICO WHERE LOWER(nome_medico) LIKE ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome.toLowerCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medico m = new Medico(
                            rs.getInt("id_medico"),
                            rs.getString("nome_medico"),
                            rs.getString("crm"),
                            rs.getString("especialidade"),
                            rs.getString("email"),
                            rs.getString("telefone")
                    );
                    lista.add(m);
                }
            }
        }
        return lista;
    }
}