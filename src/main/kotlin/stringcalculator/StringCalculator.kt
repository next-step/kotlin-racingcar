package stringcalculator

import stringcalculator.extractor.Extractor
import stringcalculator.splitter.Splitter

class StringCalculator(
    private val splitter: Splitter<String>,
    private val operandListExtractor: Extractor<ArrayDeque<Number>>,
    private val operatorListExtractor: Extractor<ArrayDeque<Operator>>
) {

    fun calculate(input: String?): Number {
        require(!input.isNullOrBlank()) { "Invalid Input: $input" }

        val splitInput = splitter.split(input).map { it.trim() }
        val operands = operandListExtractor.extract(splitInput)
        val operators = operatorListExtractor.extract(splitInput)
        val summary: Number = operands.removeFirst()

        require(operands.size == operators.size) { "Invalid Input: $input" }

        return operands.zip(operators).fold(summary) { acc, (operand, operator) ->
            operator.operate(acc, operand)
        }
    }
}
