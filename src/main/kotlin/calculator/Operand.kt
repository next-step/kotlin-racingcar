package calculator

data class Operand(val rawNumber: String) {
    val value: Int = rawNumber.toInt()

    companion object {
        val isOrderOf: (Int) -> Boolean = fun(order: Int): Boolean { return order % 2 == 0 }
        val CONVERT_TO_OPERAND: (String) -> Operand = fun(input: String): Operand { return Operand(input) }
    }
}
