package calculator.application.service

import calculator.application.port.`in`.CalculateCommand
import calculator.application.port.`in`.CalculateUseCase
import calculator.application.service.Operator.ADD
import calculator.application.service.Operator.DIV
import calculator.application.service.Operator.MUL
import calculator.application.service.Operator.SUB

class Engine(
    private val tokenizer: Tokenizer,
) : CalculateUseCase {

    override fun compute(calculateCommand: CalculateCommand): String {
        val infixTokens: List<String> = tokenizer.tokenize(calculateCommand.expr!!)

        var result: Int = infixTokens[0].toInt()
        for (i in 1 until infixTokens.size step 2) {
            result = calculate(
                leftOperand = result,
                rightOperand = infixTokens[i + 1].toInt(),
                operator = infixTokens[i],
            )
        }
        return result.toString()
    }

    private fun calculate(
        leftOperand: Int,
        rightOperand: Int,
        operator: String,
    ): Int {
        return when (operator) {
            ADD.operator -> ADD.calculate(leftOperand, rightOperand)
            SUB.operator -> SUB.calculate(leftOperand, rightOperand)
            MUL.operator -> MUL.calculate(leftOperand, rightOperand)
            DIV.operator -> {
                if (rightOperand == 0) {
                    throw ArithmeticException("나누기 연산의 오른쪽 피연산자가 0입니다.")
                }
                DIV.calculate(leftOperand, rightOperand)
            }

            else -> throw IllegalArgumentException()
        }
    }
}
