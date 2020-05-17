package br.fepi.si.app;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.si.model.Lancamento;
import br.fepi.si.model.Pessoa;
import br.fepi.si.model.TipoLancamento;
import br.fepi.si.util.JPAUtil;

public class LancamentoApp {

	private static EntityManager em;
	private static EntityTransaction et;
	
	public static void main(String[] args) {		
		
		try {
			
			em = JPAUtil.getEntityManager(); 
			et = em.getTransaction();
			
			et.begin();
			
			Calendar dataVencimento1 = Calendar.getInstance();
			dataVencimento1.set(2020, 9, 5, 0, 0, 0);
			
			Calendar dataVencimento2 = Calendar.getInstance();
			dataVencimento2.set(2020, 12, 1, 0, 0, 0);
			
			Pessoa cliente = new Pessoa();
			cliente.setNome("João Tavares");
			Pessoa fornecedor = new Pessoa();
			fornecedor.setNome("Rende Menos");
			
			Lancamento lancamento1 = new Lancamento();
			lancamento1.setDescricao("Venda de Pão");
			lancamento1.setPessoa(cliente);
			lancamento1.setDataVencimento(dataVencimento1.getTime());
			lancamento1.setDataPagamento(dataVencimento1.getTime());
			lancamento1.setValor(new BigDecimal(103_000));
			lancamento1.setTipo(TipoLancamento.RECEITA);
			
			Lancamento lancamento2 = new Lancamento();
			lancamento2.setDescricao("Venda de Café");
			lancamento2.setPessoa(cliente);
			lancamento2.setDataVencimento(dataVencimento1.getTime());
			lancamento2.setDataPagamento(dataVencimento1.getTime());
			lancamento2.setValor(new BigDecimal(15_000));
			lancamento2.setTipo(TipoLancamento.RECEITA);
			
			Lancamento lancamento3 = new Lancamento();
			lancamento3.setDescricao("Pinga de Leite");
			lancamento3.setPessoa(fornecedor);
			lancamento3.setDataVencimento(dataVencimento2.getTime());		
			lancamento3.setValor(new BigDecimal(68_000));
			lancamento3.setTipo(TipoLancamento.DESPESA);
			
			em.persist(cliente);
			em.persist(fornecedor);
			em.persist(lancamento1);
			em.persist(lancamento2);
			em.persist(lancamento3);
			
			et.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage().toUpperCase());
		} finally {
			em.close();					
		}		
	}

}
