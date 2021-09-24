package application;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Progama {

	public static void main (String[] args) {
		
		System.out.println("teste");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 1);
		System.out.println(p);
		
		Pessoa pessoaAdd = new Pessoa(null, "pessoaAdd5", "pessoa@gmail5.com");
		
		em.getTransaction().begin();
		em.persist(pessoaAdd);
		em.getTransaction().commit();
	
		em.getTransaction().begin();
		em.remove(em.find(Pessoa.class, 4));
		em.getTransaction().commit();
		
		em.close();
		emf.close();		
	}
}
