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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "diplomas")
@Data
public class Diploma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	@NotNull(message = "Student cannot be null")
	private AcademicYear academicYear;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "major_id", nullable = false)
	@NotNull(message = "Major cannot be null")
	private Major major;

	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private DiplomaStatus status;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
