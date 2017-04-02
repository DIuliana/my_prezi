package ac.sop.prezi.persist.repo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.persist.entities.User;


public interface UserRepository extends JpaRepository<User, Long>,UserRepositoryCustom{


	User findById(long id);
	User findByUserName(String username);
	List<User>findByRole(Role role);
	
}
