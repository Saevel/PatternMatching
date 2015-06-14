val i:Int = -17

val sample = i match {
    case 0 => 0
    case 1 => 1
    case _ => -1
}

def abs(n:Double):Double = (n >= 0) match {
    case true => n
    case false => (-1)*n
}

abs(1.17)

abs(-4.3)

abs(0)


