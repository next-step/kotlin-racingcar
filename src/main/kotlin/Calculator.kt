class Calculator {
    fun calculate(input: String?) {
        require(!input.isNullOrBlank()) { "Input must have a value" }
    }

    fun sum(
        a: Int,
        b: Int,
    ): Int = a + b

    fun subtract(
        a: Int,
        b: Int,
    ): Int = a - b

    fun multiply(
        a: Int,
        b: Int,
    ): Int = a * b

    fun divide(
        a: Int,
        b: Int,
    ): Int = a / b
}
