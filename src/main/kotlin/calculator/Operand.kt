package calculator

data class Operand(private val value: Long) {

    constructor(value: String) : this(value.toLong())

    operator fun plus(other: Operand): Operand {
        return Operand(this.value + other.value)
    }

    operator fun minus(other: Operand): Operand {
        return Operand(this.value - other.value)
    }

    operator fun times(other: Operand): Operand {
        return Operand(this.value * other.value)
    }

    operator fun div(other: Operand): Operand {
        if (other == ZERO) throw IllegalArgumentException("0 으로 나눌 수 없습니다.")
        return Operand(this.value / other.value)
    }

    companion object {
        val ZERO = Operand(0L)
    }
}
