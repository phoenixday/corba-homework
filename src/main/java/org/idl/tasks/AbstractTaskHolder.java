package org.idl.tasks;

/**
* tasks/AbstractTaskHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from InitialTask.idl
* Monday, March 13, 2023 8:52:56 AM CET
*/

public final class AbstractTaskHolder implements org.omg.CORBA.portable.Streamable
{
  public org.idl.tasks.AbstractTask value = null;

  public AbstractTaskHolder ()
  {
  }

  public AbstractTaskHolder (org.idl.tasks.AbstractTask initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.idl.tasks.AbstractTaskHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.idl.tasks.AbstractTaskHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.idl.tasks.AbstractTaskHelper.type ();
  }

}