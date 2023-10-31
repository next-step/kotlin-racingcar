package calculator.application.service

import calculator.application.port.`in`.CalculateCommand
import calculator.application.port.`in`.CalculateUseCase

class Engine(
    private val tokenizer: Tokenizer,
) : CalculateUseCase {

    override fun compute(calculateCommand: CalculateCommand): String {
        val infixTokens: List<String> = tokenizer.tokenize(calculateCommand.expr!!)

        var result: Operand = Operand.fromString(infixTokens[0])
        for (i in 1 until infixTokens.size step 2) {
            result = calculate(
                leftOperand = result,
                rightOperand = Operand.fromString(infixTokens[i + 1]),
                operator = Operator.findByString(infixTokens[i]),
            )
        }
        return result.value.toString()
    }

    private fun calculate(
        leftOperand: Operand,
        rightOperand: Operand,
        operator: Operator,
    ): Operand {
        return operator.calculate(leftOperand, rightOperand)
    }
}
