package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Role;

public interface RoleService {

	Role findById(Long id);
	List<Role>findAll();
	Role findByName(String name);

}
