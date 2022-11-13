package calcualator

enum class Operator(
    val value: String,
) : (Number, Number) -> Number {

    ADD("+") {
        override fun invoke(p1: Number, p2: Number): Number {
            return p1.plus(p2)
        }
    },
    MINUS("-") {
        override fun invoke(p1: Number, p2: Number): Number {
            return p1.minus(p2)
        }
    },
    TIMES("*") {
        override fun invoke(p1: Number, p2: Number): Number {
            return p1.times(p2)
        }
    },
    DIV("/") {
        override fun invoke(p1: Number, p2: Number): Number {
            return p1.div(p2)
        }
    };

    companion object {
        fun of(s: String): Operator {
            return values().firstOrNull { it.value == s }
                ?: throw IllegalArgumentException("적절한 연산자를 찾을 수 없습니다.")
        }
    }
}
