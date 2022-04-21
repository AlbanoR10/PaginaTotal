package com.example.demo.model;

import java.io.Serializable;

public class JwtPeticion implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
;	private String password;
	
	//need default constructor for JSON Parsing
	public JwtPeticion()
	{
		
	}

	public JwtPeticion(String nombreUsuario, String contraseña) {
		this.setUsername(nombreUsuario);
		this.setPassword(contraseña);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}