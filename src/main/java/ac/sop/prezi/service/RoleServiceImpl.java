package ac.sop.prezi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.persist.repo.interfaces.RoleRepository;
import ac.sop.prezi.service.interfaces.RoleService;

@Component
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findById(long id) {
		
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

	@Override
	public Role findByName(String name) {
		
		return roleRepository.findByName(name);
	}

	
}
