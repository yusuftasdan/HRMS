package kodlama.io.hrms.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kodlama.io.hrms.entities.concretes.Resume;
import kodlama.io.hrms.entities.dtos.ResumeAddDto;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		modelMapper.addMappings(new PropertyMap<ResumeAddDto, Resume>() {
	
			protected void configure() {
				map().setPhoto(source.getPhoto());
				map().setGithubLink(source.getGithubLink());
				map().setLinkedinLink(source.getLinkedinLink());
				map().setDescription(source.getDescription());
				map().setCreatingDate(source.getCreatingDate());
				map().setUpdatingDate(source.getUpdatingDate());
				map().setActive(source.isActive());
				map().getTechnology().setId(source.getTechnologyId());
				map().getLanguage().setId(source.getLanguageId());
				map().getJobExperience().setId(source.getJobExperienceId());
				map().getCandidate().setId(source.getCandidateId());
			}
		});
		return modelMapper;
	}
	
}
