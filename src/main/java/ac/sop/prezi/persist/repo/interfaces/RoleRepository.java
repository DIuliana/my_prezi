package ac.sop.prezi.persist.repo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.sop.prezi.persist.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findById(Long id);
	
	Role findByName(String name);
	
}
