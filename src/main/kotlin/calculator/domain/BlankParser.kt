package calculator.domain

class BlankParser {

    fun parseOperators(expression: String): Operators {
        return Operators()
    }

    fun parseOperands(expression: String): Operands {
        return Operands()
    }
}
