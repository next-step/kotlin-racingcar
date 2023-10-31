package calculator

sealed interface Operation

sealed interface BinaryOperation : Operation {
    fun run(operand1: Int, operand2: Int): Int
}
