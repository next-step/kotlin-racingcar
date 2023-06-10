package step2

data class Operand(
    private val value: Double
) {

    infix operator fun plus(other: Operand): Operand {
        return Operand(value + other.value)
    }

    infix operator fun minus(other: Operand): Operand {
        return Operand(value - other.value)
    }

    infix operator fun times(other: Operand): Operand {
        return Operand(value * other.value)
    }

    infix operator fun div(other: Operand): Operand {
        return Operand(value / other.value)
    }

    companion object {
        fun from(candidate: String): Operand? {
            return Operand(candidate.toDoubleOrNull() ?: return null)
        }
    }

    val double: Double
        get() = value
}
