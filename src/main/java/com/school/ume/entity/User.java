package com.school.ume.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "First name is required")
	@Column(name = "first_name", nullable = false, length = 50)
	@Size(max = 50, message = "First name must be at most 50 characters")
	private String firstName;

	@NotNull(message = "Last name is required")
	@Column(name = "last_name", nullable = false, length = 50)
	@Size(max = 50, message = "Last name must be at most 50 characters")
	private String lastName;

	@NotNull(message = "Email is required")
	@Column(name = "email", nullable = false, unique = true, length = 100)
	@Size(max = 100, message = "Email must be at most 100 characters")
	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "Password is required")
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull(message = "Role is required")
	@Column(name = "role", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private UserRole role = UserRole.STAFF;

	@NotNull(message = "Status is required")
	@Column(name = "status", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.ACTIVE;

	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@Column(name = "deleted_at", nullable = true)
	private LocalDateTime deletedAt;
}
