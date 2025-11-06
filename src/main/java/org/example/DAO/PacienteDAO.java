package org.example.DAO;

import org.example.Model.Paciente;
import org.example.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public void create(Paciente p) throws SQLException {
        String sql = "INSERT INTO HC_PACIENTE (id_paciente, nome, idade, sexo, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPaciente());
            ps.setString(2, p.getNome());
            ps.setInt(3, p.getIdade());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getTelefone());
            ps.executeUpdate();
        }
    }

    public List<Paciente> readAll() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM HC_PACIENTE";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getInt("id_paciente"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo"),
                        rs.getString("email"),
                        rs.getString("telefone")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    public void update(Paciente p) throws SQLException {
        String sql = "UPDATE HC_PACIENTE SET nome = ?, idade = ?, sexo = ?, email = ?, telefone = ? WHERE id_paciente = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getIdade());
            ps.setString(3, p.getSexo());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getTelefone());
            ps.setInt(6, p.getIdPaciente());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM HC_PACIENTE WHERE id_paciente = ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Paciente> buscarPorNome(String nome) throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM HC_PACIENTE WHERE LOWER(nome) LIKE ?";
        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome.toLowerCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Paciente p = new Paciente(
                            rs.getInt("id_paciente"),
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("sexo"),
                            rs.getString("email"),
                            rs.getString("telefone")
                    );
                    lista.add(p);
                }
            }
        }
        return lista;
    }
}