package calcualator

data class Number(private val value: String) {
    fun plus(number: Number): Number {
        return Number(this.value.toInt().plus(number.value.toInt()).toString())
    }

    fun minus(number: Number): Number {
        return Number(this.value.toInt().minus(number.value.toInt()).toString())
    }

    fun times(number: Number): Number {
        return Number(this.value.toInt().times(number.value.toInt()).toString())
    }

    fun div(number: Number): Number {
        return Number(this.value.toInt().div(number.value.toInt()).toString())
    }
}
