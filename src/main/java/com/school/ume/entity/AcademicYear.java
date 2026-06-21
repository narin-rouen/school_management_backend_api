package com.school.ume.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "academic_years")
@Data
public class AcademicYear {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	@NotBlank(message = "Academic year name cannot be blank")
	@Size(max = 50, message = "Academic year name cannot exceed 50 characters")
	private String name;

	@Column(name = "start_date", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "end_date", nullable = false)
	@CreationTimestamp
	private LocalDateTime updatedAt;
}
