package calculator


enum class Operation(val char: String, val operate: (first: Int, second:Int) -> Int) {
    PLUS("+", { first: Int, second: Int -> first + second }),
    MINUS("-", { first: Int, second: Int -> first - second }),
    MULTIPLE("*", { first: Int, second: Int -> first * second }),
    DIVIDE("/", { first: Int, second: Int -> first / second });

    fun calc(first: Int, second: Int): Int {
        return operate.invoke(first, second)
    }

    companion object {
        @JvmStatic
        fun operationOf(operation: String): Operation {
            return values().firstOrNull { item -> item.char == operation } ?: throw IllegalArgumentException()
        }
    }
}
