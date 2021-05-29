package model;

import java.util.Date;

public class Paciente {
    private int id;
    String nome;
    int idade;
    String endereco;
    boolean profissaoSaude;
    boolean vacinado;
    int prioridade;
    Date dataVacinacao;
    boolean isVacinado;
    public Paciente() {
    }

    public Paciente(String nome, int idade, String endereco, boolean profissaoSaude) {
        this.nome = nome;
        this.idade=idade;
        this.endereco = endereco;
        this.profissaoSaude  = profissaoSaude;
    }

    public int getId() {
        return id;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isProfissaoSaude() {
        return profissaoSaude;
    }

    public void setProfissaoSaude(boolean profissaoSaude) {
        this.profissaoSaude = profissaoSaude;
    }

    public Date getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(Date dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }
}
