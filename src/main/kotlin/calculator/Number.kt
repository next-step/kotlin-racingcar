package calculator

data class Number(val rawNumber: String) {
    val value: Int = rawNumber.toInt()

    companion object {
        val isOrderOf: (Int) -> Boolean = fun(order: Int): Boolean { return order % 2 == 0 }
        val convertToNumber: (String) -> Number = fun(input: String): Number { return Number(input) }
    }
}
