package org.idl.tasks;

/**
* tasks/MatrixTaskHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaces.idl
* Monday, March 13, 2023 8:48:23 PM CET
*/

public final class MatrixTaskHolder implements org.omg.CORBA.portable.Streamable
{
  public MatrixTask value = null;

  public MatrixTaskHolder ()
  {
  }

  public MatrixTaskHolder (MatrixTask initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MatrixTaskHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MatrixTaskHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MatrixTaskHelper.type ();
  }

}
