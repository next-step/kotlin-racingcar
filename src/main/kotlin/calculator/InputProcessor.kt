package calculator

import calculator.Const.ErrorMsg

object InputProcessor {
    private const val INPUT_DELIMITER = " "

    fun checkInputIsEmpty(expression: String?): String {
        require(!expression.isNullOrBlank()) { ErrorMsg.INPUT_IS_EMPTY_OR_BLANK_ERROR_MSG }
        return expression
    }

    fun splitInputToPairList(expression: String): Pair<List<Operator>, List<Double>> {
        val expressionList = expression.split(INPUT_DELIMITER)

        require(expressionList.size >= 3) { ErrorMsg.INPUT_SIZE_IS_WRONG_ERROR_MSG }

        val operators = expressionList.filterIndexed { idx, _ -> idx % 2 != 0 }
            .map { Operator.find(it) }

        val operands = expressionList.filterIndexed { idx, _ -> idx % 2 == 0 }
            .map {
                it.toDoubleOrNull() ?: throw NumberFormatException(ErrorMsg.OPERAND_IS_NOT_NUMBER_ERROR_MSG)
            }

        return Pair(operators, operands)
    }

}