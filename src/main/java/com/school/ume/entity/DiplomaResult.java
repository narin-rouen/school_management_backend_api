package com.school.ume.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "diploma_result")
@Data
public class DiplomaResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	@NotNull(message = "Student cannot be null")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_id", nullable = false)
	@NotNull(message = "Exam cannot be null")
	private Exam exam;

	@NotNull(message = "Score cannot be null")
	@Min(value = 0, message = "Score must be greater than or equal to 0")
	private Integer score;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
