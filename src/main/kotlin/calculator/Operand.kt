package calculator

class Operand {
    val value: Int

    constructor(rawNumber: String) {
        this.value = rawNumber.toIntOrNull()
            ?: throw NumberFormatException("올바른 피연산자 타입(Int)이 아닙니다: $rawNumber")
    }

    constructor(number: Int) {
        this.value = number
    }

    operator fun plus(nextOperand: Operand): Operand {
        return Operand(value + nextOperand.value)
    }

    operator fun minus(nextOperand: Operand): Operand {
        return Operand(value - nextOperand.value)
    }

    operator fun times(nextOperand: Operand): Operand {
        return Operand(value * nextOperand.value)
    }

    operator fun div(nextOperand: Operand): Operand {
        return Operand(value / nextOperand.value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operand

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    companion object {
        val isOrderOf: (Int) -> Boolean = fun(order: Int): Boolean { return order % 2 == 0 }
        val CONVERT_TO_OPERAND: (String) -> Operand = fun(input: String): Operand { return Operand(input) }
    }
}
