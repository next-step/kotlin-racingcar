import java.util.function.BinaryOperator

enum class Operator : BinaryOperator<Int> {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    MINUS {
        override fun apply(t: Int, u: Int): Int = t - u
    },
    MULTIPLY {
        override fun apply(t: Int, u: Int): Int = t * u
    },
    DIVIDE {
        override fun apply(t: Int, u: Int): Int = t / u
    };
}
