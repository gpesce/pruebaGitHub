package com.bitblend.spring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author Gaston Pesce
 */

@MappedSuperclass
public abstract class AbstractPersistentObject implements PersistentObjectInterface {

	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 6665818078917417743L;

	public AbstractPersistentObject() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	@Column(name = "CREATION_TIMESTAMP", nullable = false)
	private Timestamp creationTimestamp;

	@Column(name = "MODIFICATION_TIMESTAMP", nullable = false)
	private Timestamp modificationTimestamp;

	@Column(name = "CREATION_USER_ID", length = 20, nullable = false)
	private String creationUserId;

	@Column(name = "MODIFICATION_USER_ID", length = 20, nullable = false)
	private String modificationUserId;

	@Column(name = "MODIFICATION_IP_ADDRESS", length = 255, nullable = false)
	private String creationIPAddress;

	@Column(name = "CREATION_IP_ADDRESS", length = 255, nullable = false)
	private String modificationIPAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp newCreationTimestamp) {
		creationTimestamp = newCreationTimestamp;
	}

	public Timestamp getModificationTimestamp() {
		return modificationTimestamp;
	}

	public void setModificationTimestamp(Timestamp newModificationTimestamp) {
		modificationTimestamp = newModificationTimestamp;
	}

	public String getCreationUserId() {
		return creationUserId;
	}

	public void setCreationUserId(String userId) {
		creationUserId = userId;
	}

	public String getModificationUserId() {
		return modificationUserId;
	}

	public void setModificationUserId(String userId) {
		modificationUserId = userId;
	}

	public String getModificationIPAddress() {
		return modificationIPAddress;
	}

	public void setModificationIPAddress(String newIPAddress) {
		modificationIPAddress = newIPAddress;
	}

	public String getCreationIPAddress() {
		return creationIPAddress;
	}

	public void setCreationIPAddress(String newIPAddress) {
		creationIPAddress = newIPAddress;
	}

}
