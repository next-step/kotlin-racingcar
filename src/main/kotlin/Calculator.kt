class Calculator {
    fun calculate(input: String?) {
        val express = input.orEmpty()
        require(express.isNotEmpty()) { "Input must have a value" }
    }
}
