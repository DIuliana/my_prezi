package ac.sop.prezi.persist.repo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.sop.prezi.persist.entities.Presentation;
import ac.sop.prezi.persist.entities.User;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

	List<Presentation> findByUser(User user);

	Presentation findById(Long presentationId);
}
