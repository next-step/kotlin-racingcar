package next.step.calculator.service

object Calculator {
    fun calculate(command: String): Int = Expressions.evaluate(Parser.parse(command))
}
