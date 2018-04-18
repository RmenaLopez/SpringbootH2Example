package ca.pledgetovote.service;

import ca.pledgetovote.dao.PledgeRepository;
import ca.pledgetovote.model.Pledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pledgeServiceRepository")
public class PledgeServiceRepository implements PledgeService{

    @Autowired
    PledgeRepository pledgeRepository;

    @Override
    public Pledge createPledge(Pledge pledge) {
        return pledgeRepository.save(pledge);
    }

    @Override
    public List<Pledge> getAllPledges() {
        return (List<Pledge>)pledgeRepository.findAll();
    }

    @Override
    public Pledge getPledgeById(long id) {
        return pledgeRepository.findOne(id);
    }

    @Override
    public Pledge updatePledge(long id, Pledge newPledge) {
        Pledge pledgeToUpdate = pledgeRepository.findOne(id);
        pledgeToUpdate.setName(newPledge.getName());
        pledgeToUpdate.setStatement(newPledge.getStatement());
        return pledgeRepository.save(pledgeToUpdate);
    }

    @Override
    public void deletePledgeById(long id) {
        pledgeRepository.delete(id);
    }
}
