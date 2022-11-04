import java.lang.IllegalArgumentException

data class Number(private val value: String) {
    fun add(number: Number): Number {
        val result = value.toInt().plus(number.value.toInt())
        return Number(result.toString())
    }

    fun operate(beforeOperator: Operator, value: Number): Number {
        return when (beforeOperator) {
            Operator.add -> Number(this.value.toInt().plus(value.value.toInt()).toString())
            Operator.minus -> Number(this.value.toInt().minus(value.value.toInt()).toString())
            Operator.times -> Number(this.value.toInt().times(value.value.toInt()).toString())
            Operator.div -> Number(this.value.toInt().div(value.value.toInt()).toString())
            else -> throw IllegalArgumentException("")
        }
    }


}