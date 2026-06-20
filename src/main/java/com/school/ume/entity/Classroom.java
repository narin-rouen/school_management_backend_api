package com.school.ume.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "classrooms")
@Data
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	@NotBlank(message = "Classroom name is required")
	@Size(max = 100, message = "Classroom name must be less than 100 characters")
	private String name;

	@Column(name = "building", nullable = false)
	@NotBlank(message = "Building is required")
	@Size(max = 100, message = "Building name must be less than 100 characters")
	private String building;

	@Column(name = "floor", nullable = false)
	@NotBlank(message = "Floor is required")
	@Size(max = 10, message = "Floor must be less than 10 characters")
	private String floor;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
