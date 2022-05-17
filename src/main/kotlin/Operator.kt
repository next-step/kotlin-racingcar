import java.util.function.BinaryOperator

enum class Operator(val operatorString: String) : BinaryOperator<Int> {

    Plus("+") {
        override fun apply(x: Int, y: Int): Int = x + y
    },
    Subtract("-") {
        override fun apply(x: Int, y: Int): Int = x - y
    },
    Multiply("*") {
        override fun apply(x: Int, y: Int): Int = x * y
    },
    Divide("/") {
        override fun apply(x: Int, y: Int): Int = x / y
    };

    companion object {
        fun of(operationStr: String): Operator {
            return values()
                .find { op ->
                    op.operatorString.equals(operationStr)
                } ?: run {
                throw IllegalArgumentException("unknown operation")
            }
        }
    }
}
