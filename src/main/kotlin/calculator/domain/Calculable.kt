package calculator.domain

interface Calculable {
    fun calculate(number1: Operand, number2: Operand): Operand
}