package com.school.ume.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "assessments")
@Data
public class Assessment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Assessment name cannot be null")
	@Column(name = "name", nullable = false)
	@Size(min = 3, max = 100, message = "Assessment name must be between 3 and 100 characters")
	private String name;

	@NotNull(message = "Course cannot be null")
	@Column(name = "course_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;

	@NotNull(message = "Assessment type cannot be null")
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private AssessmentType type;

	@NotNull(message = "Assessment status cannot be null")
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private AssessmentStatus status;

	@NotNull(message = "Assessment date cannot be null")
	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
