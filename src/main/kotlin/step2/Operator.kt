package step2

enum class Operator(expr: String, evaluate: (num1: Int, num2: Int) -> Int) {
    PLUS("+", { num1: Int, num2: Int -> num1 + num2 }),
    MINUS("-", { num1: Int, num2: Int -> num1 - num2 }),
    MULTIPLY("*", { num1: Int, num2: Int -> num1 * num2 }),
    DIVIDE("/", { num1: Int, num2: Int -> num1 / num2 });

    var expr: String = expr
        private set
    var evaluate = evaluate
        private set
    companion object {
        fun find(target: String): Operator? {
            return Operator.values().find { it.expr == target }
        }
    }
}
