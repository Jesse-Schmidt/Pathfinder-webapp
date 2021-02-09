package com.pathfinder.data.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String nickname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String passwordHash;
	@Column(columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	private Boolean isDeleted = false;
	@CreationTimestamp
	private Timestamp creationTimestamp;

	protected User() {
	}

	public User(String nickname, String email, String passwordHash) {
		this.nickname = nickname;
		this.email = email;
		this.passwordHash = passwordHash;
	}

	public Integer getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}
}
