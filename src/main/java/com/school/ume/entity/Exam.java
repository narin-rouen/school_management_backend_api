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
@Table(name = "exams")
@Data
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Exam name cannot be null")
	@Column(name = "name", nullable = false)
	@Size(min = 3, max = 100, message = "Exam name must be between 3 and 100 characters")
	private String name;

	@NotNull(message = "Course cannot be null")
	@Column(name = "course_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;

	@NotNull(message = "Exam type cannot be null")
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private ExamType type;

	@NotNull(message = "Exam status cannot be null")
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ExamStatus status;

	@NotNull(message = "Exam date cannot be null")
	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
