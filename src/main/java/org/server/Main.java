package org.server;

import org.idl.tasks.AbstractTask;
import org.idl.tasks.InitialTask;
import org.idl.tasks.InitialTaskHelper;
import org.idl.tasks.SimpleTask;
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

        String str = "IOR:000000000000001a49444c3a7461736b732f496e697469616c5461736b3a312e3000000000000001000000000000008a000102000000000f3134372e3235312e35302e3234300000e2fe000000000031afabcb0000000020b6c969a200000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002";

//        try {
//            ORB orb = ORB.init(args, null);
//            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
//            rootpoa.the_POAManager().activate();
//
//            InitialTaskServant initialTaskServantObj = new InitialTaskServant();
//            initialTaskServantObj.setOrb(orb);
//
//            // org.omg.CORBA.Object ref = rootpoa.servant_to_reference(initialTaskServantObj);
//            org.omg.CORBA.Object ref = orb.string_to_object(str);
//            InitialTask href = InitialTaskHelper.narrow(ref);
//
//            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
//            // org.omg.CORBA.Object objRef = orb.string_to_object(str);
//            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
//
//            NameComponent path[] = ncRef.to_name("ABC");
//            ncRef.rebind(path, href);
//
//            System.out.println("Server is ready and waiting...");
//
//            for (; ; ) {
//                orb.run();
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e);
//            e.printStackTrace(System.out);
//        }

        try {
            // Step 1: Instantiate the ORB
            ORB orb = ORB.init(args, null);

            // Step 2: Resolve the PersistentHelloServant by using INS's
            // corbaname url. The URL locates the NameService running on
            // localhost and listening on 1050 and resolve
            // 'PersistentServerTutorial' from that NameService
            org.omg.CORBA.Object obj = orb.string_to_object(str);

            InitialTask initialTask = InitialTaskHelper.narrow( obj );

            // Step 3: Call the sayHello() method every 60 seconds and shutdown
            // the server. Next call from the client will restart the server,
            // because it is persistent in nature.
            System.out.println("start initial task");
            AbstractTask abstractTask = initialTask.init("485739@mail.muni.cz");
            System.out.println(abstractTask.info());
            System.out.println("initial task end");

//            System.out.println("start task");
//            SimpleTask simpleTask = (SimpleTask) abstractTask.next();
//            System.out.println(simpleTask.isReady());
//            System.out.println(simpleTask.info());
//            System.out.println("task end");
        } catch ( Exception e ) {
            System.err.println( "Exception in PersistentClient.java..." + e );
            e.printStackTrace( );
        }
    }
}