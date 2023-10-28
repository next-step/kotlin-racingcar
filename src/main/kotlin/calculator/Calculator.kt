package calculator

import calculator.enum.Op
import calculator.parser.InputParser
import calculator.parser.InputParserOutput
import calculator.parser.Parser

class Calculator(
    val parser: Parser<String, InputParserOutput> = InputParser
) {
    fun run(input: String?): Double {
        val pairNumbersAndOperators = parser.apply(input).getOrThrow()
        val inputNumbers = pairNumbersAndOperators.first
        val inputOperators = pairNumbersAndOperators.second.map { Op.match(it) }
        println(inputNumbers)
        println(inputOperators)
        return inputNumbers.reduceIndexed {
            index, front, back ->
            inputOperators[index - 1].run(front, back)
        }
    }
}
