package org.idl.tasks;


/**
* tasks/InitialTaskHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from InitialTask.idl
* Monday, March 13, 2023 8:52:56 AM CET
*/

abstract public class InitialTaskHelper
{
  private static String  _id = "IDL:tasks/InitialTask:1.0";

  public static void insert (org.omg.CORBA.Any a, org.idl.tasks.InitialTask that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.idl.tasks.InitialTask extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (org.idl.tasks.InitialTaskHelper.id (), "InitialTask");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.idl.tasks.InitialTask read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_InitialTaskStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.idl.tasks.InitialTask value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static InitialTask narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.idl.tasks.InitialTask)
      return (org.idl.tasks.InitialTask)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.idl.tasks._InitialTaskStub stub = new org.idl.tasks._InitialTaskStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static org.idl.tasks.InitialTask unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.idl.tasks.InitialTask)
      return (org.idl.tasks.InitialTask)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.idl.tasks._InitialTaskStub stub = new org.idl.tasks._InitialTaskStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}