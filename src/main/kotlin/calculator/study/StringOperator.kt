package calculator.study

enum class StringOperator(private val sign: String) {

    PLUS("+") {
        override fun apply(left: Operand, right: Operand): Operand = left.plus(right)
    },

    MINUS("-") {
        override fun apply(left: Operand, right: Operand): Operand = left.minus(right)
    },

    TIMES("*") {
        override fun apply(left: Operand, right: Operand): Operand = left.times(right)
    },

    DIV("/") {
        override fun apply(left: Operand, right: Operand): Operand = left.div(right)
    };

    companion object {

        fun of(sign: String): StringOperator =
            StringOperator.values().find { it.sign == sign }
                ?: throw IllegalArgumentException("$sign 는 지원하지 않는 연산자 기호입니다.")
    }

    abstract fun apply(left: Operand, right: Operand): Operand
}
