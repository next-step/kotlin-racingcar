package calculator

class EquationTokenizer {

    fun tokenize(equation: String): Pair<MutableList<Operand>, MutableList<Operator>> {
        val splitEquation = equation.split(" ")
        val operands = mutableListOf<Operand>()
        val operators = mutableListOf<Operator>()

        for ((index, element) in splitEquation.withIndex()) {
            if (index.isOperandIndex()) {
                operands.add(Operand(element))
                continue
            }
            operators.add(Operator.of(element))
        }

        return Pair(operands, operators)
    }
}

private fun Int.isOperandIndex() = this % 2 == 0
