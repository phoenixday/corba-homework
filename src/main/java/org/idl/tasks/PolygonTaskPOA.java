package org.idl.tasks;


/**
* tasks/PolygonTaskPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaces.idl
* Monday, March 13, 2023 9:05:24 PM CET
*/

public abstract class PolygonTaskPOA extends org.omg.PortableServer.Servant
 implements PolygonTaskOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getPolyLine", new java.lang.Integer (0));
    _methods.put ("sendResult", new java.lang.Integer (1));
    _methods.put ("info", new java.lang.Integer (2));
    _methods.put ("next", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // tasks/PolygonTask/getPolyLine
       {
         Point $result[] = null;
         $result = this.getPolyLine ();
         out = $rh.createReply();
         PolyLineHelper.write (out, $result);
         break;
       }

       case 1:  // tasks/PolygonTask/sendResult
       {
         float polyLineLength = in.read_float ();
         this.sendResult (polyLineLength);
         out = $rh.createReply();
         break;
       }

       case 2:  // tasks/AbstractTask/info
       {
         String $result = null;
         $result = this.info ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // tasks/AbstractTask/next
       {
         try {
           AbstractTask $result = null;
           $result = this.next ();
           out = $rh.createReply();
           AbstractTaskHelper.write (out, $result);
         } catch (TaskException $ex) {
           out = $rh.createExceptionReply ();
           TaskExceptionHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:tasks/PolygonTask:1.0", 
    "IDL:tasks/AbstractTask:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public PolygonTask _this() 
  {
    return PolygonTaskHelper.narrow(
    super._this_object());
  }

  public PolygonTask _this(org.omg.CORBA.ORB orb) 
  {
    return PolygonTaskHelper.narrow(
    super._this_object(orb));
  }


} // class PolygonTaskPOA
