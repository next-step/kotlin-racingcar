package step2

enum class ArithmeticOperation(
    private val expression: Char
) {
    PLUS('+') {
        override fun execute(firstNum: Int, secondNum: Int): Int {
            return firstNum + secondNum
        }
    },
    MINUS('-') {
        override fun execute(firstNum: Int, secondNum: Int): Int {
            return firstNum - secondNum
        }
    },
    MULTIPLE('*') {
        override fun execute(firstNum: Int, secondNum: Int): Int {
            return firstNum * secondNum
        }
    },
    DIVISION('/') {
        override fun execute(firstNum: Int, secondNum: Int): Int {
            if (firstNum % secondNum != 0) {
                throw throw IllegalArgumentException("$firstNum / $secondNum 은 나누어 떨어지지 않습니다.")
            }
            return firstNum / secondNum
        }
    };

    abstract fun execute(firstNum: Int, secondNum: Int): Int

    companion object {
        fun findOperation(expression: Char): ArithmeticOperation {
            return values().firstOrNull { expression == it.expression }
                ?: throw IllegalArgumentException("$expression 에 해당되는 연산자를 찾을 수 없습니다.")
        }
    }
}
