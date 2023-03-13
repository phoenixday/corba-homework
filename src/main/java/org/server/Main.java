package org.server;

// https://is.muni.cz/auth/el/1433/jaro2023/PA053/um/homework1.txt
// https://www.youtube.com/watch?v=chsR860gbsk
// https://wiki.archlinux.org/title/java#Switching_between_JVM
// https://docs.oracle.com/javase/10/tools/idlj.htm#JSWOR711
// https://nick-lab.gs.washington.edu/java/jdk1.3.1/guide/rmi-iiop/toJavaPortableUG.html

import org.idl.tasks.InitialTask;
import org.idl.tasks.InitialTaskHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class Main {
    public static void main(String[] args) throws InvalidName, AdapterInactive, WrongPolicy, ServantNotActive, org.omg.CosNaming.NamingContextPackage.InvalidName, CannotProceed, NotFound {

        String link = "http://andromeda.fi.muni.cz/~xbatko/homework1.ior";

        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            InitialTaskServant initialTaskServantObj = (InitialTaskServant) orb.string_to_object(link);
            initialTaskServantObj.setOrb(orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(initialTaskServantObj);
            InitialTask href = InitialTaskHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("ABC");
            ncRef.rebind(path, href);

            System.out.println("Server is ready and waiting...");

            for (; ; ) {
                orb.run();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}