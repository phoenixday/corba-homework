package org.idl.tasks;


/**
* tasks/PolygonTaskOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaces.idl
* Monday, March 13, 2023 9:05:24 PM CET
*/

public interface PolygonTaskOperations  extends AbstractTask
{
  Point[] getPolyLine ();
  void sendResult (float polyLineLength);
} // interface PolygonTaskOperations
