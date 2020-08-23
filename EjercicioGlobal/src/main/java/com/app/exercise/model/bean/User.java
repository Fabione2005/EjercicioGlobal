package com.app.exercise.model.bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(generator = "uuid")
	private UUID id;

	@NotNull(message = "El nombre no puede estar vacio")
	private String name;
	
	@NotNull(message = "El email no puede estar vacio")
    @Email(message = "El email debe tener un formato valido")
	private String email;
	
	@NotNull(message = "La clave no puede estar vacia")
	@Pattern(regexp = "^(?=.{4,}$$)(?=(?:.*[A-Z]))(?=.*[a-z])(?=(?:.*[0-9]){2}).*",message = "La clave debe tener un minimo de una mayuscula"
			+ ", letras minusculas y dos numeros")
	private String password;
	
	@OneToMany(targetEntity=Phone.class, fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Phone> phones;
	
	private String token;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	private LocalDateTime last_login;
	
	private boolean isActive;
	
	public User() {
		super();
	}
	
	public User(String name,
			String email,
			String password, List<Phone> phones, LocalDateTime created, LocalDateTime modified, LocalDateTime last_login,
			boolean isActive) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.isActive = isActive;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getLast_login() {
		return last_login;
	}

	public void setLast_login(LocalDateTime last_login) {
		this.last_login = last_login;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setLocalDatesWhenAdd(LocalDateTime date) 
	{
		this.created = date;
		this.modified = date;
		this.last_login = date;
	}
	
	public void setDataWhenLogged(String token) 
	{
		this.last_login = LocalDateTime.now();
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phones + ", isActive=" + isActive
				+ "]";
	}
	
	
	
}
