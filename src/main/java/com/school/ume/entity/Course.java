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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "courses")
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Course name cannot be null")
	@Column(nullable = false, length = 100)
	@Size(min = 3, max = 100, message = "Course name must be between 3 and 100 characters")
	private String name;

	@NotNull(message = "Course description cannot be null")
	@Column(nullable = false, length = 500)
	@Size(min = 10, max = 500, message = "Course description must be between 10 and 500 characters")
	private String description;

	@NotNull(message = "Course credits cannot be null")
	@Column(nullable = false)
	private Integer credits;

	@NotNull(message = "Course code cannot be null")
	@Column(nullable = false, unique = true, length = 20)
	private String code;

	@NotNull(message = "Course status cannot be null")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CourseStatus status;

	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
