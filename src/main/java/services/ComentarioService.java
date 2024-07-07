/*
 * AnnouncementService.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ComentarioRepository;
import domain.Comentario;

@Service
@Transactional
public class ComentarioService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private ComentarioRepository	comentarioRepository;



	// Constructors -----------------------------------------------------------

	public ComentarioService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Comentario create() {
		Comentario result;

		result = new Comentario();

		return result;
	}

	public Collection<Comentario> findAll() {
		Collection<Comentario> result;

		Assert.notNull(this.comentarioRepository);
		result = this.comentarioRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Collection<Comentario> findCommentsSuscription(int actorId) {
		Collection<Integer> listaIdCreador = comentarioRepository.findSuscriptorIdIdByActorId(actorId);
		Collection<Comentario> result = new ArrayList<Comentario>();
		for (Integer i : listaIdCreador) {
			for (Comentario comentario : comentarioRepository.findByActorId(i)) {
				result.add(comentario);
			}
		}
		
		return result;
	}

	public Collection<Integer> findActoresSuscription(int actorId) {
		Collection<Integer> listaIdCreador = comentarioRepository.findCreadorIdByActorId(actorId);
		
		
		return listaIdCreador;
	}

	public Comentario findOne(final int comentarioId) {
		Comentario result;

		result = this.comentarioRepository.findOne(comentarioId);

		return result;
	}

	public Comentario save(final Comentario comentario ) {
		assert comentario != null;

		Comentario result;
		
		result = this.comentarioRepository.save(comentario);

		return result;
	}

	public void delete(final Comentario comentario) {
		assert comentario != null;
		assert comentario.getId() != 0;

		Assert.isTrue(this.comentarioRepository.exists(comentario.getId()));
		System.out.println("-------------ID: "+comentario.getId());
		System.out.println("-------------Version: "+comentario.getVersion());

		this.comentarioRepository.delete(comentario);
	}

	// Other business methods -------------------------------------------------

	
	public Collection<Comentario> findByActorId(Integer id) {
		Assert.notNull(id);

		Collection<Comentario> result;

		result = this.comentarioRepository.findByActorId(id);

		return result;
	}
	

    public List<Comentario> getComentarioOrder() {
        List<Comentario> results = comentarioRepository.listComentariosOrderedDesc();
        return results;
    }

	

}
