package br.edu.ifpr.bsi.projetologmil.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class GenericModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Long getID() {
		return ID;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		GenericModel that = (GenericModel) o;
		return Objects.equals(ID, that.ID);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(ID);
	}
}
