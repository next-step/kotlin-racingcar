package study

enum class Operator {

    PLUS {
        override fun apply(left: Operand, right: Operand): Operand = left.plus(right)
    },

    MINUS {
        override fun apply(left: Operand, right: Operand): Operand = left.minus(right)
    },

    TIMES {
        override fun apply(left: Operand, right: Operand): Operand = left.times(right)
    },

    DIV {
        override fun apply(left: Operand, right: Operand): Operand = left.div(right)
    };

    abstract fun apply(left: Operand, right: Operand): Operand
}
