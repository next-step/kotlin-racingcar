enum class Operate(private val row: String) {

    PLUS("+") {
        override fun calc(num1: Double, num2: Double): Double {
            return num1 + num2
        }
    },
    MINUS("-") {
        override fun calc(num1: Double, num2: Double): Double {
            return num1 - num2
        }
    },
    MULTI("*") {
        override fun calc(num1: Double, num2: Double): Double {
            return num1 * num2
        }
    },
    DIVISION("/") {
        override fun calc(num1: Double, num2: Double): Double {
            if (num2 == 0.0)
                throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            return num1 / num2
        }
    };

    abstract fun calc(num1: Double, num2: Double): Double

    companion object {
        fun generate(row: String): Operate {
            return enumValues<Operate>().first {
                it.row == row
            }
        }
    }
}
