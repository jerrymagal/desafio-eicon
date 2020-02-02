package br.com.eicon.repository.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.google.common.base.Strings;

import br.com.eicon.filter.PedidoFilter;
import br.com.eicon.model.Cliente;
import br.com.eicon.model.Pedido;

public class PedidoSpecification {
	
	private PedidoFilter filter;
	
	public PedidoSpecification(PedidoFilter filter) {
		this.filter = filter;
	}
	
	private Specification<Pedido> numeroIgual(Integer numero) {
		return (root, query, builder) -> builder.equal(root.get("numero"), numero);
	}
	
	private Specification<Pedido> dataCadastroIgual(LocalDate dataCadastro) {
		return (root, query, builder) -> builder.equal(root.get("dataCadastro"), dataCadastro);
	}
	
	private Specification<Pedido> clienteIgual(Integer idCliente) {
		return (root, query, builder) -> builder.equal(root.get("cliente"), new Cliente(idCliente));
	}
	
	public Specification<Pedido> build() {
		
		Specification<Pedido> condicao = Specification.where(null);
		
		if(filter == null) return condicao;
		
		Integer numero = filter.getNumero();
		String dataCadastro = filter.getDataCadastro();
		Integer idCliente = filter.getIdCliente();
		
		if(numero != null) condicao = Specification.where(condicao).and(numeroIgual(numero));
		if(!Strings.isNullOrEmpty(dataCadastro)) condicao = Specification.where(condicao).and(dataCadastroIgual(LocalDate.parse(dataCadastro)));
		if(idCliente != null) condicao = Specification.where(condicao).and(clienteIgual(idCliente));
		
		return condicao;
	}
}
