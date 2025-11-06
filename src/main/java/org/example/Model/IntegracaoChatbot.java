package org.example.Model;

import java.sql.Date;

public class IntegracaoChatbot {
    private int idInteracao;
    private Date dataInterecao;
    private String intencao;
    private String resposta;
    private Date tempoResposta;
    private String canal;
    private String status;
    private int idFaq;
    private int idPaciente;

    public IntegracaoChatbot() {}

    public IntegracaoChatbot(int idInteracao, Date dataInterecao, String intencao, String resposta, Date tempoResposta, String canal, String status, int idFaq, int idPaciente) {
        this.idInteracao = idInteracao;
        this.dataInterecao = dataInterecao;
        this.intencao = intencao;
        this.resposta = resposta;
        this.tempoResposta = tempoResposta;
        this.canal = canal;
        this.status = status;
        this.idFaq = idFaq;
        this.idPaciente = idPaciente;
    }

    public int getIdInteracao() {
        return idInteracao;
    }

    public void setIdInteracao(int idInteracao) {
        this.idInteracao = idInteracao;
    }

    public Date getDataInterecao() {
        return dataInterecao;
    }

    public void setDataInterecao(Date dataInterecao) {
        this.dataInterecao = dataInterecao;
    }

    public String getIntencao() {
        return intencao;
    }

    public void setIntencao(String intencao) {
        this.intencao = intencao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Date getTempoResposta() {
        return tempoResposta;
    }

    public void setTempoResposta(Date tempoResposta) {
        this.tempoResposta = tempoResposta;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdFaq() {
        return idFaq;
    }

    public void setIdFaq(int idFaq) {
        this.idFaq = idFaq;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdIntegracao(int id) {
    }

    public int getIdIntegracao() {
        return 0;
    }
}
