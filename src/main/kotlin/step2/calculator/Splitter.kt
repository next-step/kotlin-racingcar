package step2.calculator

class Splitter(expression: String) {
  val left: Long
  val right: Long
  val operator: Operator
  val hasOther: Boolean
  val other: String

  init {
    expression.split(" ").let {
      if (it.size < 3) {
        throw IllegalArgumentException()
      }
      this.left = it[0].toLong()
      this.operator = Operator.findByString(it[1])
      this.right = it[2].toLong()
      this.hasOther = it.size > 3
      this.other = it.drop(3).joinToString(" ")
    }
  }
}
