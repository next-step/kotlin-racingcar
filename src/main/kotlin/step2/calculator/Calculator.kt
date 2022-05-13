package step2.calculator

class Calculator {
  companion object {
    const val DELIMITER = " "
  }

  fun execute(input: String): Long {
    return this.calculate(input.split(DELIMITER))
  }

  private fun calculate(input: List<String>): Long {
    val splitter = Splitter(input)
    val operator = splitter.arithmeticOperator
    val result = operator.calculate(splitter.left, splitter.right)

    if (splitter.hasOther) {
      return calculate(listOf(result.toString()) + input.drop(3))
    }

    return result
  }
}
