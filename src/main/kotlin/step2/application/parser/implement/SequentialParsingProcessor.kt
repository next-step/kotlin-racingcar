package step2.application.parser.implement

import step2.application.parser.ParsingProcessor
import step2.domain.calculator.model.InputOperationCommand
import step2.domain.operation.enums.Operator
import java.lang.Integer.parseInt

class SequentialParsingProcessor : ParsingProcessor {

    companion object {
        private const val SPLIT_DELIMITER = " "
        private const val SPLIT_SIZE = 2
    }

    override fun proceed(string: String): List<InputOperationCommand> {
        val splitStringArray = string.trim().split(SPLIT_DELIMITER)

        check(splitStringArray.size.isOdd()) { "식의 원소 숫자는 홀수여야 합니다." }

        val inputOperationCommandList = mutableListOf<InputOperationCommand>()

        splitStringArray.chunked(size = SPLIT_SIZE) { chunk: List<String> ->
            val number = parseInt(chunk.first())
            val operator = if (chunk.size == SPLIT_SIZE) parseOperator(chunk.last()) else Operator.ILLEGAL_STATE
            inputOperationCommandList.add(InputOperationCommand(number, operator))
        }

        return inputOperationCommandList.toList()
    }

    private fun Int.isOdd() = this % 2 != 0

    private fun parseOperator(element: String) = Operator.operatorOf(element)
}
