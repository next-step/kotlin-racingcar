package calculator

import java.math.BigDecimal
import java.math.MathContext

@JvmInline
value class Operand(private val value: BigDecimal) {
    constructor(value: Int) : this(value.toBigDecimal())
    constructor(value: Double) : this(value.toBigDecimal())

    operator fun plus(other: Operand): Operand = Operand(value.add(other.value))

    operator fun minus(other: Operand): Operand = Operand(value.subtract(other.value))

    operator fun times(other: Operand): Operand = Operand(value.multiply(other.value))

    operator fun div(other: Operand): Operand = Operand(value.divide(other.value, MathContext.DECIMAL64))

    override fun toString(): String {
        return this.value.toString().trim()
    }
}
