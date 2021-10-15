package calculator

interface Operation {
    fun perform(firstOperand: Operand, secondOperand: Operand): Operand
}
