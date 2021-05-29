package DAO;

import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class AtendenteDAO {
    String sqlSearch = "SELECT * FROM tb_paciente WHERE vacinado = 0 ORDER BY prioridade DESC;";
    String sqlAplicado = "UPDATE tb_paciente SET vacinado=1, dataVacinacao=SYSDATE() WHERE nome= ? AND id=?";
    String sqlPaciente = "SELECT id FROM tb_paciente WHERE nome = ?;";
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
    public void confirmarVacina(String nome){
        int idPaciente = this.getIdPaciente(nome);
        try{
            PreparedStatement request = con.prepareStatement(sqlAplicado);
            request.setString(1,nome);
            request.setInt(2,idPaciente);
            request.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int getIdPaciente(String nome){
        int paciente = 0;
        try{
            PreparedStatement request = con.prepareStatement(sqlPaciente);
            ResultSet rs = request.executeQuery();
            request.setString(1,nome);
            paciente = rs.getInt("id");
            request.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }
}
