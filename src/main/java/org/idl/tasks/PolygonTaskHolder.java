package org.idl.tasks;

/**
* tasks/PolygonTaskHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaces.idl
* Monday, March 13, 2023 9:05:24 PM CET
*/

public final class PolygonTaskHolder implements org.omg.CORBA.portable.Streamable
{
  public PolygonTask value = null;

  public PolygonTaskHolder ()
  {
  }

  public PolygonTaskHolder (PolygonTask initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PolygonTaskHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PolygonTaskHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PolygonTaskHelper.type ();
  }

}
