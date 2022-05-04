package calculator.domain

data class Operand(
    val value: Double
) {
    operator fun plus(operand: Operand): Operand = Operand(value + operand.value)
    operator fun minus(operand: Operand): Operand = Operand(value - operand.value)
    operator fun times(operand: Operand): Operand = Operand(value * operand.value)
    operator fun div(operand: Operand): Operand {
        if(operand.value == 0.0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다")
        }
        return Operand(value / operand.value)
    }
}
