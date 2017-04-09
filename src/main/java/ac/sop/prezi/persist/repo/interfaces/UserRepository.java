package ac.sop.prezi.persist.repo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ac.sop.prezi.persist.repo.interfaces.UserRepositoryCustom;
import ac.sop.prezi.persist.entities.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

	User findById(Long id);

}
