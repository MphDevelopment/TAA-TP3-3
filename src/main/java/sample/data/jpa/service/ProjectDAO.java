package sample.data.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Project;

@Transactional
public interface ProjectDAO extends JpaRepository<Project, Integer>{
	
	public Project findById(int id);
	
	public Project findByName(String name);
	
}
