# Corba homework

## Assignment
The goal of the assignment is to get some basic experience with CORBA technology.

Assignment comprises of several steps where you will call methods for the CORBA remote-object the interface of which will be given to you. 

You will need any implementation of CORBA in order to fulfill the assignment. As an example, you can use OmniORB for C++, native implementation of CORBA in Java JDK 8, Glassfish CORBA for Java JDK 11+, OmniORBpy for Python, etc.
https://omniorb.sourceforge.net/
https://github.com/javaee/glassfish-corba
https://sourceforge.net/projects/omniorb/files/omniORBpy/

Call the info() method to get the description of the task that is associated with the interface. The information will contain an extension of the AbstractTask interface that contains additional methods needed for the completion of the task. When you have done the task described in the info() method, call the next() method which will return the next task instance. You need to complete all the subsequent tasks until the next() method tells you that the homework was successfully completed. In case the next() method cannot give you additional task (e.g. if you did not successfully completed the task yet) an exception TaskException will be thrown and the exception message will contain additional information.

For the initial task, use your university email. 

## Useful links
https://www.youtube.com/watch?v=chsR860gbsk <br />
https://docs.oracle.com/javase/10/tools/idlj.htm#JSWOR711 <br />
https://nick-lab.gs.washington.edu/java/jdk1.3.1/guide/rmi-iiop/toJavaPortableUG.html <br />
https://docs.oracle.com/javase/7/docs/technotes/guides/idl/jidlExample2.html <br />
