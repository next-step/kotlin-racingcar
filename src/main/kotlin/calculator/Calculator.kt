package calculator

import calculator.enum.Op
import calculator.parser.Parser
import calculator.parser.ParserOutput

class Calculator(
    private val parser: Parser<String, ParserOutput<Double, String>>
) {
    fun run(input: String?): Double {
        val pairNumbersAndOperators = parser.apply(input).getOrThrow()
        val inputNumbers = pairNumbersAndOperators.numbers
        val inputOperators = pairNumbersAndOperators.operands.map { Op.match(it) }

        return inputNumbers.reduceIndexed {
            index, currentValue, accumulator ->
            inputOperators[index - 1].run(currentValue, accumulator)
        }
    }
}
