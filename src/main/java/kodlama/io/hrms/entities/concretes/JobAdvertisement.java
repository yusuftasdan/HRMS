package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="creating_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalDate creatingDate;
	
	@Column(name="ending_date")
	private LocalDate endingDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private String  minSalary;
	
	@Column(name="max_salary")
	private String maxSalary;
	
	@Column(name="open_position")
	private String openPosition;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="city_id", referencedColumnName = "id")
	private City city;
	

}
