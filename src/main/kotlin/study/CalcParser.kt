package study

object CalcParser {

    fun compile(expression: String): CalcMachine {
        CalcSyntaxChecker.validate(expression)
        return this.createCalculateMachine(expression)
    }

    private fun createCalculateMachine(expression: String): CalcMachine {
        val (stringOperators, operands) = this.parse(expression)
        return CalcMachine(stringOperators, operands)
    }

    private fun parse(expression: String): Pair<List<StringOperator>, List<Operand>> {
        val (numbers, operators) = expression.split(" ").partition(::isNumeric)
        return Pair(operators.map(StringOperator::of), numbers.map(Operand::of))
    }

    private fun isNumeric(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }
}
