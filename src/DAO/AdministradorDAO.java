package DAO;

import model.Paciente;
import model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministradorDAO extends Usuario {
    String sqlAdm = "INSERT INTO tb_administrador (login, senha, nome, administrador) VALUES(?,?,?,?)";
    String sqlAtd = "INSERT INTO tb_atendente (login, senha, nome, administrador) VALUES(?,?,?,?)";
    String sqlPct = "INSERT INTO tb_paciente (nome,idade,endereco,profissaoSaude,vacinado,prioridade, dataVacinacao) VALUES(?,?,?,?,?,?,?)";
    String sqlRlt = "SELECT vacinado FROM tb_paciente WHERE vacinado=1 ORDER BY idade ASC;";
    String sqlRemoveAdministrador = "DELETE FROM tb_administrador WHERE id = ?;";
    String sqlRemoveAtendente = "DELETE FROM tb_atendente WHERE id = ?;";
    String sqlRemovePaciente = "DELETE FROM tb_paciente WHERE id = ?;";
    ConnectionFactory connection = new ConnectionFactory();
    Connection con = connection.conexao();

    public void cadastroAdministrador(String login, String senha, String nome, boolean administrador){
//        boolean adm = administrador;
        try{
          PreparedStatement request = con.prepareStatement(sqlAdm);
          request.setString(1, login);
          request.setString(2, senha);
          request.setString(3, nome);
          request.setBoolean(4, true);
          request.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void cadastroAtendente(String login, String senha, String nome, boolean administrador){
        try{
            PreparedStatement request = con.prepareStatement(sqlAtd);
            request.setString(1, login);
            request.setString(2, senha);
            request.setString(3, nome);
            request.setBoolean(4, false);
            request.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cadastroPaciente(String nome,Integer idade, String endereco, boolean profissaoSaude,boolean vacinado, Date dataVacinacao){
        // validação de prioridade da vacina

        Paciente novoPaciente = new Paciente();
        int prioridadePct= 0;
        if(idade>=70){
            prioridadePct = 1;
        }else if(profissaoSaude==true){
            prioridadePct = 2;
        }else{
            prioridadePct = 3;
        }
        System.out.println(prioridadePct);
        try{
            PreparedStatement request = con.prepareStatement(sqlPct);
            request.setString(1, nome);
            request.setInt(2, idade);
            request.setString(3, endereco);
            request.setBoolean(4, profissaoSaude);
            request.setBoolean(5, false);
            request.setInt(6, prioridadePct);
            request.setDate(7, null);

            request.execute();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void removerAdministrador (Integer id){
        try{
            PreparedStatement request = con.prepareStatement(sqlRemoveAdministrador);
            request.setInt(1, id);
            request.execute();
        }catch (Exception e){
            return;
        }
    }

    public void removerAtendente (Integer id){
        try{
            PreparedStatement request = con.prepareStatement(sqlRemoveAtendente);
            request.setInt(1, id);
            request.execute();
        }catch (Exception e){
            return;
        }
    }

    public void gerarRelatorio(){
        try{
            PreparedStatement request = con.prepareStatement(sqlRlt);
            ResultSet rs = request.executeQuery();
            Paciente paciente = new Paciente();
            while(rs.next()){
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");
                boolean profissaoSaude = rs.getBoolean("profissaoSaude");
                boolean vacinado = rs.getBoolean("vacinado");
                int prioridade = rs.getInt("prioridade");
                java.util.Date dataVacinacao = rs.getDate("dataVacinacao");
                paciente.setNome(nome);
                paciente.setIdade(idade);
                paciente.setEndereco(endereco);
                paciente.setProfissaoSaude(profissaoSaude);
                paciente.setVacinado(vacinado);
                paciente.setPrioridade(prioridade);
                paciente.setDataVacinacao(dataVacinacao);
                System.out.println(paciente.isVacinado());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
