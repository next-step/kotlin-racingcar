package calcualator

data class Number(private val value: Int) {
    fun plus(number: Number): Number {
        return Number(this.value.plus(number.value))
    }

    fun minus(number: Number): Number {
        return Number(this.value.minus(number.value))
    }

    fun times(number: Number): Number {
        return Number(this.value.times(number.value))
    }

    fun div(number: Number): Number {
        return Number(this.value.div(number.value))
    }
}
