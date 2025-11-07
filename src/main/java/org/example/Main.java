package org.example;

import org.example.DAO.*;
import org.example.Model.*;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Paciente
            PacienteDAO pacienteDAO = new PacienteDAO();
            Paciente paciente = new Paciente(1, "Ana Souza", 28, "Feminino", "ana@fiap.com.br", "11999990001");
            pacienteDAO.create(paciente);

            List<Paciente> pacientes = pacienteDAO.readAll();
            for (Paciente p : pacientes) {
                System.out.println("Paciente: " + p.getNome());
            }

            paciente.setNome("Ana S. Lima");
            pacienteDAO.update(paciente);

            List<Paciente> buscaPacientes = pacienteDAO.buscarPorNome("ana");
            for (Paciente p : buscaPacientes) {
                System.out.println("Busca Paciente: " + p.getNome());
            }

            // Médico
            MedicoDAO medicoDAO = new MedicoDAO();
            Medico medico = new Medico(1, "Dr. Carlos", "CRM12345", "Cardiologia", "carlos@fiap.com.br", "11988880001");
            medicoDAO.create(medico);

            List<Medico> medicos = medicoDAO.readAll();
            for (Medico m : medicos) {
                System.out.println("Médico: " + m.getNomeMedico());
            }

            medico.setEspecialidade("Clínico Geral");
            medicoDAO.update(medico);

            List<Medico> buscaMedicos = medicoDAO.buscarPorNome("carlos");
            for (Medico m : buscaMedicos) {
                System.out.println("Busca Médico: " + m.getNomeMedico());
            }

            // Agendamento
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
            Agendamento agendamento = new Agendamento(1, Date.valueOf("2025-10-05"), Date.valueOf("2025-10-05"),
                    "Cardiologia", "Confirmado", 1, 1, 0);
            agendamentoDAO.create(agendamento);

            List<Agendamento> agendamentos = agendamentoDAO.readAll();
            for (Agendamento a : agendamentos) {
                System.out.println("Agendamento: " + a.getEspecialidade());
            }

            agendamento.setStatus("Remarcado");
            agendamentoDAO.update(agendamento);

            List<Agendamento> buscaAgendamentos = agendamentoDAO.buscarPorNome("cardio");
            for (Agendamento a : buscaAgendamentos) {
                System.out.println("Busca Agendamento: " + a.getEspecialidade());
            }

            // Interação Chatbot
            IntegracaoChatbotDAO chatbotDAO = new IntegracaoChatbotDAO();
            IntegracaoChatbot interacao = new IntegracaoChatbot(1, Date.valueOf("2025-09-30"), "Consulta",
                    "Você pode agendar online", Date.valueOf("2025-09-30"), "WhatsApp", "Respondido", 0, 1);
            chatbotDAO.create(interacao);

            List<IntegracaoChatbot> interacoes = chatbotDAO.readAll();
            for (IntegracaoChatbot i : interacoes) {
                System.out.println("Interação: " + i.getIntencao());
            }

            interacao.setResposta("Use o app para agendar");
            chatbotDAO.update(interacao);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}