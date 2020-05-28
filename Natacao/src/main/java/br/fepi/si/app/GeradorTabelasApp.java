package br.fepi.si.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorTabelasApp {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		
		try {
			emf = 	Persistence.createEntityManagerFactory("NatacaoPU");
			em = emf.createEntityManager();
			System.out.println("Tabelas Criadas com Sucesso.");
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		finally {
			em.close();//Fecha a conexão com o banco. 
			emf.close();//Fecha a conexão com o banco.	
		}

	}

}
