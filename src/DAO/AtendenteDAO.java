package DAO;

import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtendenteDAO {
    String sqlSearch = "SELECT * FROM tb_paciente WHERE vacinado = 0 ORDER BY prioridade DESC;";
    String sqlAplicado = "UPDATE tb_paciente SET vacinado=1, dataVacinacao=NOW() WHERE nome=(SELECT ";
    ConnectionFactory connection = new ConnectionFactory();
    Connection con = connection.conexao();

    public void buscarPacientes(){
        try{
            PreparedStatement request = con.prepareStatement(sqlSearch);
            ResultSet rs = request.executeQuery();
            Paciente paciente = new Paciente();
            while(rs.next()){
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");
                boolean profissaoSaude = rs.getBoolean("profissaoSaude");
                boolean vacinado = rs.getBoolean("vacinado");
                int prioridade = rs.getInt("prioridade");
                Date dataVacinacao = rs.getDate("dataVacinacao");
                paciente.setNome(nome);
                paciente.setIdade(idade);
                paciente.setEndereco(endereco);
                paciente.setProfissaoSaude(profissaoSaude);
                paciente.setVacinado(vacinado);
                paciente.setPrioridade(prioridade);
                paciente.setDataVacinacao(dataVacinacao);
                }
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void confirmarVacina(String nome){ //TO-DO
        try{
            String command = sqlAplicado + nome + "FROM tb_paciente);";
            PreparedStatement request = con.prepareStatement(command);
            request.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
