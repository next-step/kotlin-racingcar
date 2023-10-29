package step2

object StringCalculator {
    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank())

        val tokens = tokenize(input)
        return calculateByIterator(tokens)
    }

    private fun tokenize(input: String): List<String> {
        val tokens = input.trim().split(" ")
        require(tokens.size % 2 != 0)

        return tokens
    }

    private fun calculateByIterator(tokens: List<String>): Int {
        var lazyFunc: (Int, Int) -> Int = { _, _ -> 0 }
        return tokens.reduceIndexed { index, acc, s ->
            if (index % 2 == 1) {
                lazyFunc = Symbol.from(s).calc
                acc
            } else {
                lazyFunc(acc.toInt(), s.toInt()).toString()
            }
        }.toInt()
    }
}

enum class Symbol(val value: String, val calc: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun from(value: String): Symbol {
            return values().find { it.value == value }
                ?: throw IllegalArgumentException("invalid operator")
        }
    }
}
