package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.Version;

import lombok.Data;

import org.hibernate.envers.Audited;

//@Data
@Audited
@MappedSuperclass
public abstract class GenericModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Version
	@Column(name = "version")
	private Long version;
	
	@Column(name = "active")
	private boolean active = true;
	
	@Column(name = "deleted")
	private boolean deleted = false;
	
	@Column(name = "created_at")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date createdAt;
	
	@Column(name = "updated_at")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date updatedAt;
	
	@PrePersist
	public void setCreationDate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void setChangeDate() {
		this.updatedAt = new Date();
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
