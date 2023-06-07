package calculator

import java.lang.IllegalArgumentException

const val CALCULATOR_DELIMITER = " "
const val OPERATOR_REGEX = "^[+\\-*/]+$"
const val OPERAND_REGEX = "\\d+"

class Calculator {

    companion object {
        fun calculate(expression: String?): Int {
            checkExpression(expression)
            val expressionList = splitExpression(expression!!)
            val operands = filterOperands(expressionList)
            val operators = filterOperators(expressionList)

            return calculate(operands, operators)
        }

        private fun checkExpression(expression: String?) {
            if (expression.isNullOrBlank()) {
                throw IllegalArgumentException("expression is cannot be null or blank")
            }
        }

        private fun splitExpression(expression: String): List<String> {
            return expression.split(CALCULATOR_DELIMITER)
        }

        private fun filterOperands(expressionList: List<String>): List<String> {
            val operands = expressionList.filterIndexed { index, _ -> index % 2 == 0 }
            checkOperands(operands)
            return operands
        }

        private fun checkOperands(operands: List<String>) {
            val invalidOperand = operands.firstOrNull { !Regex(OPERAND_REGEX).matches(it) }
            if (invalidOperand != null) {
                throw IllegalArgumentException("operand should be number [0-9]")
            }
        }

        private fun filterOperators(expressionList: List<String>): List<String> {
            val operators = expressionList.filterIndexed { index, _ -> index % 2 != 0 }
            checkOperators(operators)
            return operators
        }

        private fun checkOperators(operators: List<String>) {
            val invalidOperator = operators.firstOrNull { !Regex(OPERATOR_REGEX).matches(it) }
            if (invalidOperator != null) {
                throw IllegalArgumentException("not supported operator")
            }
        }

        private fun calculate(operands: List<String>, operators: List<String>): Int {
            val firstOperand = operands[0]
            var result = 0
            for (i in 1 until operands.size) {
                val operator = Operator.findBySymbol(operators[i - 1])
                if (i == 1) {
                    result += operator.calculate(firstOperand.toInt(), operands[i].toInt())
                } else {
                    operator.calculate(result, operands[i].toInt())
                }
            }

            return result
        }
    }
}
