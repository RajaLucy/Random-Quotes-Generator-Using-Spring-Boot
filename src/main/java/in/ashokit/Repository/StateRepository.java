package in.ashokit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.States;

public interface StateRepository extends JpaRepository<States, Integer>{
	
	
	public List<States> findByCounId(Integer cid);

}
