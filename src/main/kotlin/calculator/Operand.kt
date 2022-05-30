package calculator

class Operand(input: String = "0.0") {
    val value: Double = input.toDoubleOrNull() ?: throw IllegalArgumentException("입력값이 잘못되었습니다. input: $input")

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operand

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
