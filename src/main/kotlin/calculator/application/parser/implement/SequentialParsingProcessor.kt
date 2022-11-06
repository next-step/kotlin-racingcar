package calculator.application.parser.implement

import calculator.application.parser.ParsingProcessor
import calculator.domain.calculator.model.InputOperationCommand
import calculator.domain.operation.enums.Operator

class SequentialParsingProcessor : ParsingProcessor {

    override fun proceed(string: String): List<InputOperationCommand> {
        val splitStringArray = string.trim().split(SPLIT_DELIMITER)

        check(splitStringArray.size.isOdd()) { "식의 원소 숫자는 홀수여야 합니다." }

        val inputOperationCommandList = mutableListOf<InputOperationCommand>()

        splitStringArray.chunked(size = SPLIT_SIZE) { chunk: List<String> ->
            val number = chunk.first().toInt()
            val operator = if (chunk.size == SPLIT_SIZE) parseOperator(chunk.last()) else Operator.EMPTY_OPERATOR
            inputOperationCommandList.add(InputOperationCommand(number, operator))
        }

        return inputOperationCommandList.toList()
    }

    private fun Int.isOdd() = this % 2 != 0

    private fun parseOperator(element: String) = Operator.operatorOf(element)

    companion object {
        private const val SPLIT_DELIMITER = " "
        private const val SPLIT_SIZE = 2
    }
}
