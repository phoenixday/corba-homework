package org.server;

import org.idl.tasks.AbstractTask;
import org.idl.tasks.InitialTaskPOA;
import org.idl.tasks.TaskException;
import org.omg.CORBA.ORB;

public class InitialTaskServant extends InitialTaskPOA {

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    @Override
    public AbstractTask init(String email) throws TaskException {
        return null;
    }
}
