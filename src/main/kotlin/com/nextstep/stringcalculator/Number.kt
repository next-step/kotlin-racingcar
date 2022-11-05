package com.nextstep.stringcalculator

data class Number(val value: Long) : Element {
    constructor(stringNumber: String) : this(stringNumber.toLong())

    operator fun plus(other: Number): Number = Number(this.value + other.value)

    operator fun minus(other: Number): Number = Number(this.value - other.value)

    operator fun times(other: Number): Number = Number(this.value * other.value)

    operator fun div(other: Number): Number = Number(this.value / other.value)
}
