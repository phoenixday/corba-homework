package org.idl.tasks;

/**
* tasks/FlipLineTaskHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaces.idl
* Monday, March 13, 2023 9:31:28 PM CET
*/

public final class FlipLineTaskHolder implements org.omg.CORBA.portable.Streamable
{
  public FlipLineTask value = null;

  public FlipLineTaskHolder ()
  {
  }

  public FlipLineTaskHolder (FlipLineTask initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = FlipLineTaskHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    FlipLineTaskHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return FlipLineTaskHelper.type ();
  }

}
