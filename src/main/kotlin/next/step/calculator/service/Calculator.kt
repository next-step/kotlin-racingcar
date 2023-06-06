package next.step.calculator.service

import next.step.calculator.domain.Expressions

object Calculator {
    fun calculate(command: String): Int = Expressions.of(Parser.parse(command)).evaluate()
}
