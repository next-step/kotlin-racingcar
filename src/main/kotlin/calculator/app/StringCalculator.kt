package calculator.app

import calculator.model.Arithmetic
import calculator.model.Operand
import calculator.model.Operator

class StringCalculator {

    fun calculate(input: String?): Int {
        val inputString: String = validate(input)
        val arithmetic: Arithmetic = parseToFormula(inputString)
        return arithmetic.act()
    }

    private fun parseToFormula(inputString: String): Arithmetic {
        val operators: List<Operator> = Operator.parseOperators(inputString)
        val operands: List<Operand> = Operand.parseOperands(inputString)
        return Arithmetic(operators, operands)
    }

    private fun validate(input: String?): String {
        requireNotNull(input) { "null 입력은 허용되지 않습니다" }
        assertNotEmpty(input)
        return input
    }

    private fun assertNotEmpty(input: String) {
        require(input.isNotEmpty())
    }
}
