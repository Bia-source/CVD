package DAO;

import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {
    String sqlSearch = "SELECT * FROM tb_paciente WHERE vacinado = 0 ORDER BY prioridade DESC;";
    String sqlAplicado = "UPDATE tb_paciente SET vacinado=1, dataVacinacao=NOW() WHERE nome=(SELECT ";
    ConnectionFactory connection = new ConnectionFactory();
    Connection con = connection.conexao();

    public ArrayList<Paciente> buscarPacientes(){
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ResultSet rs = null;
        try{
            PreparedStatement request = con.prepareStatement(sqlSearch);

            rs = request.executeQuery();

            while (rs.next()){
                Paciente paciente = new Paciente();
                paciente.setNome(rs.getString("nome"));
                paciente.setIdade(rs.getInt("idade"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setProfissaoSaude(rs.getBoolean("profissaoSaude"));
                paciente.setVacinado(rs.getBoolean("vacinado"));
                paciente.setPrioridade(rs.getInt("prioridade"));
                paciente.setDataVacinacao(rs.getDate("dataVacinacao"));
                pacientes.add(paciente);
                System.out.println(pacientes);
                System.out.println(paciente);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return pacientes;
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
