package calculator

import calculator.operation.DivideOperation
import calculator.operation.InfixOperation
import calculator.operation.MinusOperation
import calculator.operation.MultiplyOperation
import calculator.operation.NumberOperation
import calculator.operation.PlusOperation

class InfixCalculator(private val expression: String?) {
    init {
        if (expression == null) {
            throw IllegalArgumentException("수식은 null 일 수 없습니다.")
        }

        if (expression.isBlank()) {
            throw IllegalArgumentException("수식은 공백 일 수 없습니다.")
        }
    }

    fun calculate() = parseExpression().operate()

    private fun parseExpression(): InfixOperation {
        val expressionWithoutSpace = eraseWhiteSpace(expression)
        validateExpressionFormat(expressionWithoutSpace)

        val operands = expressionWithoutSpace
            .split("[+\\-*/]".toRegex())
            .asSequence()
            .filter { it.isNotBlank() }
            .toList()

        val operators = expressionWithoutSpace
            .replace("\\d".toRegex(), "")
            .asSequence()
            .map { it.toString() }
            .toList()

        if (operands.size <= operators.size) throw IllegalArgumentException("연산자가 피연산자 보다 많을 수 없습니다.")

        var result: InfixOperation = NumberOperation(operands[0])
        for (i in operators.indices) {
            result = getOperator(operators[i], result, NumberOperation(operands[i + 1]))
        }

        return result
    }

    private fun getOperator(
        input: String,
        leftOperation: InfixOperation,
        rightOperation: InfixOperation
    ): InfixOperation =
        when (input) {
            "+" -> PlusOperation(leftOperation, rightOperation)
            "-" -> MinusOperation(leftOperation, rightOperation)
            "*" -> MultiplyOperation(leftOperation, rightOperation)
            "/" -> DivideOperation(leftOperation, rightOperation)
            else -> throw IllegalArgumentException("지원 하지 않는 연산자입니다.")
        }

    private fun eraseWhiteSpace(expression: String?) = expression?.replace("\\s".toRegex(), "")!!

    private fun validateExpressionFormat(expression: String) {
        if (!expression.matches("[\\d+\\-*/]+".toRegex())) {
            throw IllegalArgumentException("수식은 사칙연산과 숫자만 가능합니다.")
        }
    }
}
