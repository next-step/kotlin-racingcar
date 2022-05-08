package step2.calculator

class Splitter(private val expression: String) {
  val other: String = "+ 5"
  val hasOther: Boolean = true
  val operator: Operator = Operator.PLUS
  val left: Long = 3
  val right: Long = 4
}
