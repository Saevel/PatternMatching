package org.jug.patternmatching.task4

import org.jug.patternmatching.task2.fibonacci
import org.scalacheck._

import org.scalacheck.Prop._

import org.scalacheck.Arbitrary._

/**
 * Created by Zielony on 12.06.15.
 */
object TaskFourSpec extends Properties("Task Four - Validation"){

  val email = for {
    host <- arbitrary[String]
    domain <- arbitrary[String]
    countryCode <- arbitrary[String]
  } yield(Email(host, domain, countryCode))

  val phoneNumber = for {
    prefix <- arbitrary[Int]
    main <- arbitrary[Long]
  } yield(PhoneNumber(prefix, main))

  val address = for {
    streetName <- arbitrary[String]
    streetNumber <- arbitrary[String]
    city <- arbitrary[String]
    country <- arbitrary[String]
  } yield(Address(streetName, streetNumber, city, country))

  val fullContact = for {
    addr <- address
    em <- email
    number <- phoneNumber
  } yield(ContactData(Some(addr), Some(em), Some(number)));

  val contactWithoutAddress = for {
    em <- email
    number <- phoneNumber
  } yield(ContactData(None, Some(em), Some(number)))

  val contactWithoutEmail = for {
    addr <- address
    number <- phoneNumber
  } yield(ContactData(Some(addr), None, Some(number)))

  val contactWithoutPhone = for {
    addr <- address
    em <- email
  } yield(ContactData(Some(addr), Some(em), None));

  val contactWithAddress = for {
    addr <- address
  } yield(ContactData(Some(addr), None, None));

  val contactWithEmail = for {
    em <- email
  } yield (ContactData(None, Some(em), None));

  val contactWithPhone = for {
    number <- phoneNumber
  } yield (ContactData(None, None, Some(number)))

  val someContactData = Gen.oneOf(fullContact, contactWithoutAddress, contactWithoutEmail, contactWithoutPhone,
    contactWithAddress, contactWithEmail, contactWithPhone);

  val noContactData = Gen.const(ContactData(None, None, None))

  val largerThanOrEqualToEight = Gen.choose(8, 30);

  val smallerThanEigth = Gen.choose(1, 7);

  val shortPassword = for {
    length <- smallerThanEigth
  } yield Gen.listOfN(length, Gen.alphaChar).map(_.mkString);

  val longPassword = for {
    length <- largerThanOrEqualToEight
  } yield Gen.listOfN(length, Gen.alphaChar).map(_.mkString);

  /*
   * TODO: Za krótkie hasło i kontakt, odpowiednie hasło bez kontaktu, odpowienie hasło i kontakt,
   * za krótkie hasło bez kontaktu
   */
  val correctRegistration = for {
    cd <- someContactData
    password <- longPassword
    pwd <- password
    username <- arbitrary[String]
  } yield(Registration(username, pwd, cd));

  val registrationWithPasswordTooShort = for {
    cd <- someContactData
    password <- shortPassword
    pwd <- password
    username <- arbitrary[String]
  } yield(Registration(username, pwd, cd));

  val registrationWithoutContactData = for {
    cd <- noContactData
    password <- longPassword
    pwd <- password
    username <- arbitrary[String]
  } yield(Registration(username, pwd, cd));

  val registrationWithoutContactDataAndShortPassword = for {
    cd <- noContactData
    password <- shortPassword
    pwd <- password
    username <- arbitrary[String]
  } yield(Registration(username, pwd, cd));

  property("correctRegistration") = forAll(correctRegistration){(registration:Registration) =>
    validateRegistration(registration)}

  property("passwordTooShort") = forAll(registrationWithPasswordTooShort){(registration:Registration) =>
    !validateRegistration(registration)
  }

  property("noContactData") = forAll(registrationWithoutContactData){(registration:Registration) =>
    !validateRegistration(registration)
  }

  property("noContactDataAndPasswordTooShort") = forAll(registrationWithoutContactDataAndShortPassword) {
    (registration: Registration) => !validateRegistration(registration)
  }
}