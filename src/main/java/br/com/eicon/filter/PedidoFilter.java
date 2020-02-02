package br.com.eicon.filter;

import io.swagger.annotations.ApiModelProperty;

public class PedidoFilter {

	@ApiModelProperty(value = "Número do pedido")
	private Integer numero;

	@ApiModelProperty(value = "Data do cadastro do pedido. Formato yyyy-MM-dd")
	private String dataCadastro;

	@ApiModelProperty(value = "Id do cliente")
	private Integer idCliente;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
}
