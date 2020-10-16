package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Task;

@Transactional
public interface TaskDAO extends JpaRepository<Task, Integer>{

	public Task findById(int id);
	
	@Query("update Task t set t.category = ?2 where id = ?1")
	public void changeCategory(int id, String category);
}
