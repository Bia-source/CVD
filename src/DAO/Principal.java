package DAO;

import model.Atendente;

import java.sql.Date;

public class Principal {
    public static  void main (String[] args){
        int option = 3;
       switch (option){
           // cadastro adm - ADM
           case 1:
               String login = "Beatriz@rd.com";
               String senha = "1901395";
               String nome = "Beatriz";
               boolean administrador = true ;
               AdministradorDAO createAdministradorDAO = new AdministradorDAO();
               createAdministradorDAO.cadastroAdministrador(login,senha,nome,administrador);
               break;
           // cadastro atendente - ADM
           case 2:
               String loginAtendente = "atendete2@rd.com";
               String senhaAtendente = "1u34364";
               String nomeAtendente = "atendente2";
               boolean administradorAtende = false ;
               AdministradorDAO createAtendente = new AdministradorDAO();
               createAtendente.cadastroAtendente(loginAtendente,senhaAtendente,nomeAtendente,administradorAtende);
               break;
           // cadastro paciente - ADM
           case 3:
               String nomePaciente = "paciente10";
               Integer idadePaciente = 18;
               String enderecoPaciente = "AV.Matarazzo";
               boolean profissaoSaude = true;
               boolean vacinado = false;
               Date dataVacinacao = null;
               AdministradorDAO createPaciente = new AdministradorDAO();
               createPaciente.cadastroPaciente(nomePaciente,idadePaciente, enderecoPaciente, profissaoSaude,vacinado,dataVacinacao);
               break;
           //buscando pacientes - ATENDENTE
           case 4:
               AtendenteDAO atendente = new AtendenteDAO();
               atendente.buscarPacientes();
               break;
           //buscando pacientes - ATENDENTE
           case 5:
               String nomeAserVacinado = "paciente1";
               AtendenteDAO atendente1 = new AtendenteDAO();
               atendente1.buscarPacientes();
               break;
           // confirmar vacina paciente - ATENDENTE
           case 6:
               String nomePacienteVacina = "paciente1";
               AtendenteDAO a = new AtendenteDAO();
               a.confirmarVacina(nomePacienteVacina);
               break;
           // removendo administrador - ADM
           case 7:
               Integer idAdm = 1;
               AdministradorDAO adm = new AdministradorDAO();
               adm.removerAdministrador(idAdm);
               break;
           // removendo atendente - ADM
           case 8:
               Integer idAtd = 1;
               AdministradorDAO atd = new AdministradorDAO();
               atd.removerAtendente(idAtd);
               break;

       }


    }
}
