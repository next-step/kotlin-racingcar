package calculator

enum class Operator(expr: String, evaluate: (num1: Int, num2: Int) -> Int) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    var display: String = expr
        private set
    var evaluate = evaluate
        private set

    companion object {
        fun find(target: String): Operator {
            return values().find { it.display == target }
                ?: throw IllegalArgumentException("+, -, *, / 외에는 사용할 수 없습니다.")
        }
    }
}
