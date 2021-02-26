package caculator

data class Number(private val value: Double) {

    constructor(value: String) : this(value.toDouble())

    operator fun plus(number: Number): Number {
        return Number(this.value + number.value)
    }

    operator fun minus(number: Number): Number {
        return Number(this.value - number.value)
    }

    operator fun times(number: Number): Number {
        return Number(this.value * number.value)
    }

    operator fun div(number: Number): Number {
        return Number(this.value / number.value)
    }
}
