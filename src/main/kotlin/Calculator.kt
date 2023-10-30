class Calculator(val formula: String) {
    val formulas = formula.split(" ").toMutableList()

    enum class operator(val op: String) {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/")
    }

    val numberPattern = Regex("\\d+")

    fun calculate(): Int {
        if (
            formulas.any {
                !(
                    it in operator.values().map { it.op } ||
                        numberPattern.matches(it)
                    )
            }
        ) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }

        var prev = 0
        while (formulas.isNotEmpty()) {
            val word = formulas.removeFirst()
            if (numberPattern.matches(word)) {
                prev = word.toInt()
            } else if (word in operator.values().map { it.op }) {
                val first = prev
                val second = formulas.removeFirst().toInt()
                first - second
                val result = when (word) {
                    operator.PLUS.op -> prev = first + second
                    operator.MINUS.op -> prev = first - second
                    operator.MULTIPLY.op -> prev = first * second
                    operator.DIVIDE.op -> prev = first / second
                    else -> throw IllegalArgumentException("잘못된 입력입니다.")
                }
            } else {
                throw IllegalArgumentException("잘못된 입력입니다.")
            }
        }

        return prev
    }
}
