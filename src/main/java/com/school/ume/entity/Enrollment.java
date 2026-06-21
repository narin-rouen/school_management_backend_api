package com.school.ume.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "enrollment")
@Data
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Semester cannot be null")
	private Semester semester;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classroom_id", nullable = false)
	@NotNull(message = "Classroom cannot be null")
	private Classroom classroom;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Status cannot be null")
	private EnrollmentStatus status;

	@Column(name = "start_date", nullable = false)
	@NotNull(message = "Start date cannot be null")
	private LocalDateTime strartDate;

	@Column(name = "end_date", nullable = false)
	@NotNull(message = "End date cannot be null")
	private LocalDateTime endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable = false)
	@NotNull(message = "Academic year cannot be null")
	private AcademicYear academicYear;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "generation_id", nullable = false)
	@NotNull(message = "Generation cannot be null")
	private Generation generation;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Time cannot be null")
	private Time time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "major_id", nullable = false)
	@NotNull(message = "Major cannot be null")
	private Major major;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
