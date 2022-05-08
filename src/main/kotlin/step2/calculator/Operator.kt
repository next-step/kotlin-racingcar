package step2.calculator

enum class Operator(val operator: String) {
  PLUS("+"),
  MINUS("-"),
  MULTIPLE("*"),
  DIVIDE("/");

  companion object {
    fun findByString(string: String): Operator =
      values().find { it.operator == string } ?: throw Error()
  }
}
