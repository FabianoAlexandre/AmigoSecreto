package br.fateczl.les.amigosecreto.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import br.fateczl.les.amigosecreto.entidade.Evento;
import br.fateczl.les.amigosecreto.util.FabricaEntityManager;

public class EventoDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void salvar(Evento evento){ //salvar e editar*
		 
			EntityManager entityManager = FabricaEntityManager.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(evento);  //com o merge, caso já exista algo ele substitui
				entityManager.getTransaction().commit();
			} finally {
				entityManager.close();
			}
		}
		
		public Evento buscar(Long id){
			EntityManager entityManager = FabricaEntityManager.getEntityManager();
			Evento resultado = null;
			try {
				resultado = entityManager.find(Evento.class, id);
			} finally {
				entityManager.close();
			}
			return resultado;
		}
		
		public void excluir(Evento evento){
			EntityManager entityManager = FabricaEntityManager.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(evento);
				entityManager.getTransaction().commit();
			} finally {
				entityManager.close();
			}
		}
}
