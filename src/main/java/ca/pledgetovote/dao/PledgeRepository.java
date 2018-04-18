package ca.pledgetovote.dao;


import ca.pledgetovote.model.Pledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PledgeRepository extends CrudRepository<Pledge, Long> {
}
