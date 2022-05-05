package study

enum class Operator {

    PLUS {
        override fun calc(left: Operand, right: Operand): Operand = left.plus(right)
    },

    MINUS {
        override fun calc(left: Operand, right: Operand): Operand = left.minus(right)
    },

    TIMES {
        override fun calc(left: Operand, right: Operand): Operand = left.times(right)
    },

    DIV {
        override fun calc(left: Operand, right: Operand): Operand = left.div(right)
    };

    abstract fun calc(left: Operand, right: Operand): Operand
}
