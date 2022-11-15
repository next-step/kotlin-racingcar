package com.nextstep.stringcalculator

data class Operand(val value: Long) : Element {
    constructor(stringNumber: String) : this(stringNumber.toLong())

    operator fun plus(other: Operand): Operand = Operand(this.value + other.value)

    operator fun minus(other: Operand): Operand = Operand(this.value - other.value)

    operator fun times(other: Operand): Operand = Operand(this.value * other.value)

    operator fun div(other: Operand): Operand = Operand(this.value / other.value)
}
