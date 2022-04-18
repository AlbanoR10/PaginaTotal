package com.example.demo.model;

import java.io.Serializable;

public class JwtPeticion implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String nombreUsuario;
	private String contraseña;
	
	//need default constructor for JSON Parsing
	public JwtPeticion()
	{
		
	}

	public JwtPeticion(String nombreUsuario, String contraseña) {
		this.setNombreUsuario(nombreUsuario);
		this.setContraseña(contraseña);
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String username) {
		this.nombreUsuario = username;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}