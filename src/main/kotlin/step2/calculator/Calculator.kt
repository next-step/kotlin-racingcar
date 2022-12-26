package step2.calculator

import step2.calculator.vo.CalculatorInput
import step2.calculator.vo.from

class Calculator(
    private val inputs: List<CalculatorInput>
) {
    companion object
}

fun Calculator.Companion.from(input: String): Calculator {
    return Calculator(extractInputs(input));
}

private fun extractInputs(input: String): List<CalculatorInput> {
    return input.split(" ").asSequence()
        .filter { it.isNotBlank() }
        .map { CalculatorInput.from(it) }
        .toList();
}
