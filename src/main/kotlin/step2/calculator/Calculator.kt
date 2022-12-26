package step2.calculator

import step2.calculator.vo.CalculatorInput
import step2.calculator.vo.Number
import step2.calculator.vo.from

class Calculator(
    private val inputs: Inputs
) {
    fun calculate(): Number {
        var result = inputs.nextNumber;

        while(inputs.hasNextNumber && inputs.hasNextOperation) {
            val operation = inputs.nextOperation
            val operand = inputs.nextNumber

            result = operation.calculate(result, operand)
        }

        return result
    }

    companion object
}

fun Calculator.Companion.from(input: String): Calculator {
    return Calculator(Inputs.from(extractInputs(input)))
}

private fun extractInputs(input: String): List<CalculatorInput> {
    return input.split(" ").asSequence()
        .filter { it.isNotBlank() }
        .map { CalculatorInput.from(it) }
        .toList();
}
