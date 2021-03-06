package org.jug.patternmatching.task4

/**
 * Created by Zielony on 12.06.15.
 */
object validateRegistration extends (Registration => Boolean){

  def apply(registration: Registration):Boolean = registration match {
    case Registration(_, _, ContactData(None, None, None)) => false;
    case Registration(username, password, _) => (!username.equals(password) && password.length >= 8 );
    case _ => false;
  }
}
