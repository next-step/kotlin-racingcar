package study.step2

enum class ArithmeticOperator(
    val symbol: String,
    val operation: (Int, Int) -> Int
) {
    ADD("+", { op1, op2 -> op1 + op2 }),
    SUB("-", { op1, op2 -> op1 - op2 }),
    MUL("*", { op1, op2 -> op1 * op2 }),
    DIV("/", { op1, op2 -> op1 / op2 });

    companion object {
        fun getSymbol(inputSymbol: String) = values().firstOrNull {
            it.symbol == inputSymbol
        }?.symbol ?: throw IllegalArgumentException()

        fun operate(
            inputOperator: String,
            operand1: Int,
            operand2: Int
        ) = values().first {
            it.symbol == inputOperator
        }.operation(operand1, operand2)
    }
}
