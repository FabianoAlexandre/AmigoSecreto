package br.fateczl.les.amigosecreto.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.fateczl.les.amigosecreto.entidade.Participante;
import br.fateczl.les.amigosecreto.util.FabricaEntityManager;


public class ParticipanteDAO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void salvar(Participante participante){ //salvar e editar*
	/**	Set<Participante> participanteSet = new HashSet<>(); 
		for (Iterator<Participante> iterator = participanteSet.iterator(); iterator.hasNext();) {
			participanteSet.add(participante);
		}
		em.persist(participante);
	}
	**/ 
		EntityManager entityManager = FabricaEntityManager.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(participante);  //com o merge, caso já exista algo ele substitui
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	public Participante buscar(Long id){
		EntityManager entityManager = FabricaEntityManager.getEntityManager();
		Participante resultado = null;
		try {
			resultado = entityManager.find(Participante.class, id);
		} finally {
			entityManager.close();
		}
		return resultado;
	}
	
	public void excluir(Participante participante){
		EntityManager entityManager = FabricaEntityManager.getEntityManager();
		//Participante participante = null;
		try {
			entityManager.getTransaction().begin();
			//participante = entityManager.find(Participante.class, id);
			entityManager.remove(participante);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
}
