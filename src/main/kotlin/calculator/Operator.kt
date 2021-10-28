package calculator

// TODO: OperatorTest 추가하기
enum class Operator {
    PLUS {
        override fun execute(first: Double, second: Double): Double {
            return first + second
        }
    },
    MINUS {
        override fun execute(first: Double, second: Double): Double {
            return first - second
        }
    },
    MULTIPLY {
        override fun execute(first: Double, second: Double): Double {
            return first * second
        }
    },
    DIVISION {
        // TODO: 나누기는 0일때 예외처리 추가하기
        override fun execute(first: Double, second: Double): Double {
            return first / second
        }
    };

    // TODO: 함수형프로그래밍! enum class 생성자? 로 받기
    abstract fun execute(first: Double, second: Double): Double

    companion object {
        fun getOperatorEnum(operator: String): Operator {
            return when (operator) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVISION
                else -> throw IllegalArgumentException(Message.INVALID_OPERATOR)
            }
        }
    }
}
