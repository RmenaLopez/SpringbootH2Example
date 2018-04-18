package ca.pledgetovote.service;

import ca.pledgetovote.dao.PledgeDao;
import ca.pledgetovote.model.Pledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pledgeManager")
public class PledgeServiceImpl implements PledgeService {
    @Autowired
    //@Qualifier(value = "PledgeH2")
    PledgeDao dao;

    @Override
    public Pledge createPledge(Pledge pledge) {
        return dao.createPledge(pledge);
    }

    @Override
    public List<Pledge> getAllPledges() {
        return dao.getAllPledges();
    }

    @Override
    public Pledge getPledgeById(long id) {
        return dao.getOnePledge(id);
    }

    @Override
    public Pledge updatePledge(long id, Pledge newPledge) {
        return dao.updatePledge(id, newPledge);
    }

    @Override
    public void deletePledgeById(long id) {
        dao.deletePledgeById(id);
    }
}
