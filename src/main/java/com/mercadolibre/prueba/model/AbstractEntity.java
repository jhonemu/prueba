package com.mercadolibre.prueba.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * <p>AbstractEntity</p>
 * Clase Abstracta para generar campos de auditoria
 * @author Jhon
 *
 */
@MappedSuperclass
public class AbstractEntity implements Serializable{
	private static final long serialVersionUID = -5992225615143947648L;
	@CreatedBy
	@Column(name="CREATED_BY", nullable = false)
	private String createdBy;
	@CreatedDate
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	@Column(name = "MODIFIED_BY")
	@LastModifiedBy
	private String modifiedBy;
	@Column(name = "MODIFIED_AT")
	@LastModifiedDate
	private Date modifiedAt;
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
