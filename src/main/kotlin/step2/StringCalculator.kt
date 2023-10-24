package step2

class StringCalculator {
    companion object {
        fun calculate(input: String): Int {
            input.split(" ").let {
                it[1].let { operator ->
                    return when (operator) {
                        "+" -> it[0].toInt() + it[2].toInt()
                        "-" -> it[0].toInt() - it[2].toInt()
                        else -> it[0].toInt() * it[2].toInt()
                    }
                }
            }
        }
    }
}
