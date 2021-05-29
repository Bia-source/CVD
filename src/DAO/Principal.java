package DAO;

import java.sql.Date;

public class Principal {
    public static  void main (String[] args){
        int option = 4;
       switch (option){
           // cadastro adm
           case 1:
               String login = "Beatriz@rd.com";
               String senha = "1901395";
               String nome = "Beatriz";
               boolean administrador = true ;
               AdministradorDAO createAdministradorDAO = new AdministradorDAO();
               createAdministradorDAO.cadastroAdministrador(login,senha,nome,administrador);
               break;
           // cadastro atendente
           case 2:
               String loginAtendente = "atendete2@rd.com";
               String senhaAtendente = "1u34364";
               String nomeAtendente = "atendente2";
               boolean administradorAtende = false ;
               AdministradorDAO createAtendente = new AdministradorDAO();
               createAtendente.cadastroAtendente(loginAtendente,senhaAtendente,nomeAtendente,administradorAtende);
               break;
           // cadastro paciente
           case 3:
               String nomePaciente = "paciente2";
               Integer idadePaciente = 36;
               String enderecoPaciente = "AV.Dos Andrades";
               boolean profissaoSaude = true;
               boolean vacinado = false;
               Date dataVacinacao = null;
               AdministradorDAO createPaciente = new AdministradorDAO();
               createPaciente.cadastroPaciente(nomePaciente,idadePaciente, enderecoPaciente, profissaoSaude,vacinado,dataVacinacao);
               break;
           //buscando pacientes
           case 4:
               AtendenteDAO atendente = new AtendenteDAO();
               atendente.buscarPacientes();
               break;
           //buscando pacientes
           case 5:
               String nomeAserVacinado = "paciente1";
               AtendenteDAO atendente1 = new AtendenteDAO();
               atendente1.buscarPacientes();
               break;
           // removendo paciente
           case 6:
               Integer id = 1;
               AdministradorDAO a = new AdministradorDAO();
               a.removerPaciente(id);
               break;
           // removendo administrador
           case 7:
               Integer idAdm = 1;
               AdministradorDAO adm = new AdministradorDAO();
               adm.removerAdministrador(idAdm);
               break;
           // removendo atendente
           case 8:
               Integer idAtd = 1;
               AdministradorDAO atd = new AdministradorDAO();
               atd.removerAtendente(idAtd);
               break;
       }
    }
}
