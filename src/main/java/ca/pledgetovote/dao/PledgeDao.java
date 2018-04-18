package ca.pledgetovote.dao;

import ca.pledgetovote.model.Pledge;

import java.util.List;

public interface PledgeDao {
    public List<Pledge> getAllPledges();
    public Pledge createPledge(Pledge pledge);
    public Pledge getOnePledge(long pledgeId);
    public Pledge updatePledge(long id, Pledge pledge);
    public Pledge deletePledgeById(long id);
}
