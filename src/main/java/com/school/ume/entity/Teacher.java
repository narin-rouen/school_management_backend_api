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
@Table(name = "teachers")
@Data
public class Teacher {

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

	@NotNull(message = "Date of birth is required")
	@Column(name = "date_of_birth", nullable = false)
	private LocalDateTime dateOfBirth;

	@NotNull(message = "Phone number is required")
	@Column(name = "phone_number", nullable = false, length = 20)
	@Size(max = 20, message = "Phone number must be at most 20 characters")
	private String phoneNumber;

	@NotNull(message = "Address is required")
	@Column(name = "address", nullable = false, length = 500)
	@Size(max = 500, message = "Address must be at most 500 characters")
	private String address;

	@Column(name = "profile_picture_url", length = 500)
	@Size(max = 500, message = "Profile picture URL must be at most 500 characters")
	private String profilePictureUrl;

	@NotNull(message = "Subject is required")
	@Column(name = "subject", nullable = false, length = 100)
	@Size(max = 100, message = "Subject must be at most 100 characters")
	private String nationality;

	@NotNull(message = "Religion is required")
	@Column(name = "religion", nullable = false, length = 50)
	@Size(max = 50, message = "Religion must be at most 50 characters")
	private String religion;

	@NotNull(message = "Status is required")
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private TeacherStatus status;

	@NotNull(message = "Gender is required")
	@Column(name = "gender", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
