package study

class Direction() {
    fun plus(list: List<Int>): Int {
        return list.sum()
    }

    fun minus(a: Int, b: Int): Int {
        return a - b
    }

    fun multiplication(a: Int, b: Int): Int {
        return a * b
    }

    fun division(a: Int, b: Int): Int {
        if (b == 0) {
            throw ArithmeticException("0의값으로 나눌순 없습니다")
        }
        return a / b
    }

    fun isPlus(symbol: String): Boolean {
        return symbol == "+"
    }

    fun isMinus(symbol: String): Boolean {
        return symbol == "-"
    }

    fun isMultiplication(symbol: String): Boolean {
        return symbol == "*"
    }

    fun isDivision(symbol: String): Boolean {
        return symbol == "/"
    }

    fun calculate(symbol: String, calculateNumList: MutableList<Int>): Int {
        return when {
            isPlus(symbol) -> {
                plus(calculateNumList)
            }
            isMinus(symbol) -> {
                minus(calculateNumList[0], calculateNumList[1])
            }
            isMultiplication(symbol) -> {
                multiplication(calculateNumList[0], calculateNumList[1])
            }
            isDivision(symbol) -> {
                division(calculateNumList[0], calculateNumList[1])
            }
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다")
        }
    }
}
