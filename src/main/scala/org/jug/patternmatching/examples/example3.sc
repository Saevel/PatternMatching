def maxValue(n:Any):Option[Double] = n match {
    case d:Double => Some(Double.MaxValue)
    case i:Int => Some(Int.MaxValue)
    case l:Long => Some(Long.MaxValue)
    case f:Float => Some(Float.MaxValue)
    case _ => None
}

maxValue(12)

maxValue(12L)

maxValue(12.0)

maxValue(12f)

maxValue("someText")