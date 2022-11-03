data class Number(private val value: Int) {
    fun add(number: Number): Number {
        return Number(value.plus(number.value))
    }
}