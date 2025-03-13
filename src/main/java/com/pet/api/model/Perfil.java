package com.pet.api.model;

public enum Perfil {

	 CLIENTE,
	 ADMIN;
	
	public String getRole() {
        return "ROLE_" + this.name();
    }
}