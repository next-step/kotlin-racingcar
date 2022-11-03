package step2.application.parser.implement

import step2.application.parser.ParsingProcessor
import step2.domain.calculator.model.InputOperationCommand
import step2.domain.operation.enums.Operator
import java.lang.Integer.parseInt

class SequentialParsingProcessor : ParsingProcessor {

    companion object {
        private const val SPLIT_DELIMITER = " "
    }

    override fun proceed(string: String): List<InputOperationCommand> {
        val splitStringArray = string.trim().split(SPLIT_DELIMITER)

        check(splitStringArray.size.isOdd()) { "식의 원소 숫자는 홀수여야 합니다." }

        val inputOperationCommandList = mutableListOf<InputOperationCommand>()

        splitStringArray.windowed(size = 2, step = 2, partialWindows = true) { window: List<String> ->
            val number = parseInt(window.first())
            val operator = if (window.size == 2) parseOperator(window.last()) else Operator.ILLEGAL_STATE
            inputOperationCommandList.add(InputOperationCommand(number, operator))
        }

        return inputOperationCommandList.toList()
    }

    private fun Int.isOdd() = this % 2 != 0

    private fun parseOperator(element: String) = Operator.operatorOf(element)
}
