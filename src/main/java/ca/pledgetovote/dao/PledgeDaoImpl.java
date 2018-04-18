package ca.pledgetovote.dao;

import ca.pledgetovote.model.Pledge;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository("PledgeDao")
public class PledgeDaoImpl implements PledgeDao {
    List<Pledge> pledges;
    private AtomicLong nextId = new AtomicLong();

    public PledgeDaoImpl() {
        pledges = new ArrayList<Pledge>();
        Pledge pledge1 = new Pledge(
                nextId.incrementAndGet(),
                "Pete testinto",
                "A test statement"
        );
        Pledge pledge2 = new Pledge(
                nextId.incrementAndGet(),
                "Second testing guy",
                "Lol wut, another test?"
        );
        pledges.add(pledge1);
        pledges.add(pledge2);
    }

    @Override
    public List<Pledge> getAllPledges() {
        return pledges;
    }

    @Override
    public Pledge createPledge(Pledge pledge) {
        pledge.setId(nextId.incrementAndGet());
        pledges.add(pledge);
        return  pledge;
    }

    @Override
    public Pledge getOnePledge(long pledgeId) {
        return findPledgeById(pledgeId);
    }

    @Override
    public Pledge updatePledge(long id, Pledge newPledge) {
        Pledge pledgeToRemove = findPledgeById(id);
        pledges.remove(pledgeToRemove);
        newPledge.setId(id);
        pledges.add(newPledge);
        return pledgeToRemove;
    }

    @Override
    public Pledge deletePledgeById(long id) {
        Pledge pledgeToDelete = findPledgeById(id);
        pledges.remove(pledgeToDelete);
        return pledgeToDelete;
    }

    private Pledge findPledgeById(long id){
        for (Pledge pledge : pledges){
            if (pledge.getId() == id){
                return pledge;
            }
        }
        throw new IllegalArgumentException();
    }

}
