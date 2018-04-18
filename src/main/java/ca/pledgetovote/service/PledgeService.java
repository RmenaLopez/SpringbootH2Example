package ca.pledgetovote.service;

import ca.pledgetovote.model.Pledge;

import java.util.List;

public interface PledgeService {
    public Pledge createPledge(Pledge pledge);
    public List<Pledge> getAllPledges();
    public Pledge getPledgeById(long id);
    public Pledge updatePledge(long id, Pledge newPledge);
    public void deletePledgeById(long id);
}
