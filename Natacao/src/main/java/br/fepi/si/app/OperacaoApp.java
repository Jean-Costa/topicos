package br.fepi.si.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.fepi.si.model.Classificacao;
import br.fepi.si.model.Estilo;
import br.fepi.si.model.Nadador;
import br.fepi.si.model.Olimpiadas;
import br.fepi.si.model.Piscina;

public class OperacaoApp {
	public static void inserir(EntityManager em) throws ParseException {
		
		Nadador cielo = new Nadador("Cielo ", "Masculino", "Brasil", 27, 10);
		cielo.setEstiloNatacao(Estilo.PEITO);
		
		Classificacao colocacaoCielo = new Classificacao();
		colocacaoCielo.setNumColocacao(1);
		cielo.setCompetidor(colocacaoCielo);
		
		Nadador felps = new Nadador("Felps", "Masculino", "Brasil", 27, 10);
		felps.setEstiloNatacao(Estilo.PEITO);
		
		Classificacao colocacaoFelps = new Classificacao();
		colocacaoFelps.setNumColocacao(2);
		felps.setCompetidor(colocacaoFelps);
		
		Olimpiadas olimpiadas = new Olimpiadas("100 metros", 
				new SimpleDateFormat("dd/MM/yyyy").parse("20/06/2021")
				, "Japão", "20 minutos");
		colocacaoCielo.setProva(olimpiadas);
		colocacaoFelps.setProva(olimpiadas);
		
		Piscina piscina = new Piscina(14.5f, 30, 26, 8);
		piscina.setCompetidor(cielo);
		piscina.setCompetidor(felps);
		
		em.persist(cielo);
		em.persist(colocacaoCielo);
		em.persist(felps);
		em.persist(colocacaoFelps);
		em.persist(olimpiadas);
		em.persist(piscina);
		
	}

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NatacaoPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			inserir(em);

			et.commit();
			System.out.println("Sucesso na operação!");

		} catch (Exception e) {
			et.rollback();
			System.out.println("Erro na operação. " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
	}
}
