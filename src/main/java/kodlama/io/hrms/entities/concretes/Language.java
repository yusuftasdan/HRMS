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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="language_name")
	private String language;
	
	@Column(name="level")
	private char level;
	
	@Column(name="creating_date")
	private LocalDate creatingDate;
	
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resumes;

}
