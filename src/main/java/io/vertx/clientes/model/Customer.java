package io.vertx.clientes.model;

import io.vertx.core.json.JsonObject;

public class Customer {
	
	private String codigo;
	private String identificador;
	private String tipoIdentificador;
	private String nombre;
	private String tipoCliente;
	private String codigoSolicitante;
	private String razonSocial;
	
	
	
	public Customer(String codigo, String identificador, String tipoIdentificador, String nombre, String tipoCliente,
			String codigoSolicitante, String razonSocial) {
		super();
		this.codigo = codigo;
		this.identificador = identificador;
		this.tipoIdentificador = tipoIdentificador;
		this.nombre = nombre;
		this.tipoCliente = tipoCliente;
		this.codigoSolicitante = codigoSolicitante;
		this.razonSocial = razonSocial;
	}
	public Customer(JsonObject x) {
		this.codigo = x.getString("codigo");
		this.identificador = x.getString("identificador");
		this.tipoIdentificador = x.getString("tipoIdentificador");
		this.nombre = x.getString("nombre");
		this.tipoCliente = x.getString("tipoCliente");
		this.codigoSolicitante = x.getString("codigoSolicitante");
		this.razonSocial = x.getString("razonSocial");
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getTipoIdentificador() {
		return tipoIdentificador;
	}
	public void setTipoIdentificador(String tipoIdentificador) {
		this.tipoIdentificador = tipoIdentificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getCodigoSolicitante() {
		return codigoSolicitante;
	}
	public void setCodigoSolicitante(String codigoSolicitante) {
		this.codigoSolicitante = codigoSolicitante;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	
}
