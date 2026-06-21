package com.school.ume.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "generations")
@Data
public class Generation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	@NotBlank(message = "Generation name cannot be blank")
	@Size(max = 50, message = "Generation name cannot exceed 50 characters")
	private String name;

	@Column(name = "start_date", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "end_date", nullable = false)
	@CreationTimestamp
	private LocalDateTime updatedAt;
}
