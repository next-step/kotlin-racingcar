package step2
import java.lang.IllegalArgumentException

enum class Operator(val value: String, val calculate: (Int, Int) -> Int){
    PLUS("+", { a , b -> a + b }),

    MINUS("-", { a, b -> a - b}),

    MULTIPLY("*", { a, b -> a * b }),

    DIVIDE("/", { a, b -> a / b });

    companion object {
        private val operators = Operator.values().associateBy(Operator::value)
        fun from(value: String) = operators[value] ?: throw IllegalArgumentException()
    }
}
