package calculator.service

import calculator.domain.Calculator
import calculator.domain.vo.Term
import calculator.validator.ExpressionValidator

class SimpleCalculatorService(
    private val calculator: Calculator,
    private val expressionValidator: ExpressionValidator,
) : CalculatorService {
    override fun execute(input: String?): Term {
        val validated = expressionValidator.validated(input)
        return calculator.calculate(validated)
    }
}
