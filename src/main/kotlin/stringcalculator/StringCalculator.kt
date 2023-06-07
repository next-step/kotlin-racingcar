package stringcalculator

import stringcalculator.extractor.OperandListExtractor
import stringcalculator.extractor.OperatorListExtractor
import stringcalculator.splitter.BlankSplitter

object StringCalculator {

    fun calculate(input: String?): Number {
        val validInput = input?.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("Invalid Input: $input")

        val splitInput = BlankSplitter.split(validInput).map { it.trim() }
        val operands = OperandListExtractor.extract(splitInput)
        val operators = OperatorListExtractor.extract(splitInput)

        var summery: Number = operands.removeFirst()

        require(operands.size == operators.size) {
            throw IllegalArgumentException("Invalid Input: $validInput")
        }

        for (operand in operands) {
            val operator = operators.removeFirst()

            summery = operator.operate(summery, operand)
        }

        return summery
    }
}
