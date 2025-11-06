package org.example.Model;
import java.sql.Date;


public class Agendamento {
    private int idAgendamento;
    private Date dataAgendamento;
    private Date horario;
    private String especialidade;
    private String status;
    private int idPaciente;
    private int idMedico;
    private int idFeedback;

    public Agendamento() {}

    public Agendamento(int idAgendamento, Date dataAgendamento, Date horario, String especialidade, String status, int idPaciente, int idMedico, int idFeedback) {
        this.idAgendamento = idAgendamento;
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
        this.especialidade = especialidade;
        this.status = status;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idFeedback = idFeedback;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }
}
