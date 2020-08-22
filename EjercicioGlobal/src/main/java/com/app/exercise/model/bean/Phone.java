package com.app.exercise.model.bean;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//@Table(name="phone")
public class Phone {

	@Id
	@GeneratedValue(generator = "uuid")
	private UUID id;
	
	@NotNull(message = "El numero no puede estar vacio")
	private long number;
	
	@NotNull(message = "El codigo de ciudad no puede estar vacio")
	@Max(value = 9999,message="El codigo de la ciudad no puede tener mas de 4 digitos")
	private Long cityCode;
	
	@Max(value = 9999,message="El codigo del pais no puede tener mas de 4 digitos")
	@NotNull(message = "El codigo de pais no puede estar vacio")
	private Long countryCode;
	
	public Phone(long number,Long cityCode,Long countryCode) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}

	public Phone() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Long getCityCode() {
		return cityCode;
	}

	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}

	public Long getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Long countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", cityCode=" + cityCode + ", countryCode=" + countryCode
				+ "]";
	}
	
	

}
