package step2

class Calculator {

    fun calculate(first: Int, symbol: String, second: Int) = when (symbol) {
        "+" -> plus(first, second)
        "-" -> minus(first, second)
        "*" -> multiply(first, second)
        "/" -> divide(first, second)
        else -> throw IllegalArgumentException()
    }

    fun calculateString(input: String?): Int {
        val inputs = input?.split(" ")
        require(!inputs.isNullOrEmpty())
        var isSymbol = true
        var result = inputs[0].toInt()
        var symbol = ""

        inputs.drop(1).forEach {
            if (checkOperator()) {
                symbol = it
            } else {
                result = calculate(result, symbol, it.toInt())
            }
            isSymbol = !isSymbol
        }
        return result
    }
}
