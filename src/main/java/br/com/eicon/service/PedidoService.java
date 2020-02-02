package br.com.eicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eicon.filter.PedidoFilter;
import br.com.eicon.model.Pedido;
import br.com.eicon.repository.PedidoRepository;
import br.com.eicon.repository.specification.PedidoSpecification;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Page<Pedido> filtrar(PedidoFilter filter, Pageable pageable) {
		PedidoSpecification spec = new PedidoSpecification(filter);
		return repository.findAll(spec.build(), pageable);
	}
}
