package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class Employer extends User {
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisement;

}
