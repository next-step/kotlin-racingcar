package calculator

import calculator.model.Operand
import calculator.model.Operator

class StringCalculator {

    fun calculate(input: String?): Int {
        val inputString: String = validate(input)
        val formula: Pair<List<Operator>, List<Operand>> = parseToFormula(inputString)
        return arithmeticAct(formula.first, formula.second)
    }

    private fun arithmeticAct(first: List<Operator>, second: List<Operand>): Int {
        TODO("Not yet implemented")
    }

    private fun parseToFormula(inputString: String): Pair<List<Operator>, List<Operand>> {
        val operators: List<Operator> = Operator.parseOperators(inputString)
        val operands: List<Operand> = Operand.parseOperand(inputString)
        return Pair(operators, operands)
    }

    private fun validate(input: String?): String {
        assertNotNull(input)
        assertNotEmpty(input)
        return input!!
    }

    private fun assertNotEmpty(input: String?) {
        TODO("Not yet implemented")
    }

    private fun assertNotNull(input: String?) {
        TODO("Not yet implemented")
    }
}
