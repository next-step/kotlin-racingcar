import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class Operator : BinaryOperator<Int>, IntBinaryOperator {
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

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}
