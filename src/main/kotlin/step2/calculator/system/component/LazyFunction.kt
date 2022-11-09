package step2.calculator.system.component

enum class LazyFunction(val sign: String) : Function {
    PLUS("+") {
        override fun evaluate(front: Double, back: Double): Double {
            return front + back
        }
    },
    MINUS("-") {
        override fun evaluate(front: Double, back: Double): Double {
            return front - back
        }
    },
    MULTIPLY("*") {
        override fun evaluate(front: Double, back: Double): Double {
            return front * back
        }
    },
    DIVIDE("/") {
        override fun evaluate(front: Double, back: Double): Double {
            if (back == 0.0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            return front / back
        }
    },
    ;
    abstract fun evaluate(front: Double, back: Double): Double

    companion object {
        fun from(input: String): LazyFunction {
            return values().firstOrNull { it.sign == input }
                ?: throw IllegalArgumentException("Not Lazy Function : $input")
        }

        fun isLazyFunction(input: String): Boolean {
            return values().map { it.sign }.contains(input)
        }
    }
}
