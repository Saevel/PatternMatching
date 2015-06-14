case class PhoneNumber(prefix:Int, body:Long);

case class Email(host:String, domain:String,
                 countryCode:String);

def generateUrl(contactData:Any):Option[String] =
  contactData match {
    case PhoneNumber(prefix, body) =>
      Some(s"tel:$prefix$body")
    case Email(host,domain, country) =>
      Some(s"mailto:$host@$domain.$country")
    case _ => None
}

generateUrl(new PhoneNumber(42, 6700400))

generateUrl(new Email("kamil","dim","pl"))

generateUrl(177)