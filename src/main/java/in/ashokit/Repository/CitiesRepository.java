package in.ashokit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Cities;

public interface CitiesRepository extends JpaRepository<Cities, Integer>{

	public List<Cities> findByStateId(Integer sid);
	
	
}
