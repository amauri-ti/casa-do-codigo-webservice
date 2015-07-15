package br.com.caelum.estoque.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
@Stateless
public class EstoqueWS {

	@Inject
	private Estoque estoque;

	public EstoqueWS() {
	}
	
	@WebMethod(operationName = "buscaItemEstoque")
	@WebResult(name = "ItemEstoque")
	public ItemEstoque getItemEstoque(@WebParam(name = "codigo") String codigo) {
		return estoque.buscaPorCodigo(codigo);
	}
	
	@WebMethod(operationName = "buscaItensEstoque")
	@WebResult(name = "ItensEstoque")
	public List<ItemEstoque> getItensEstoque(@WebParam(name = "codigos") List<String> codigos) {
		return estoque.buscaPorListaDeCodigo(codigos);
	}
	
}
