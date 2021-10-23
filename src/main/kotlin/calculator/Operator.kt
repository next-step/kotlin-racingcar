package calculator

enum class Operator(private val symbol: String) {
    PLUS("+"), MINUS("-"), MULTIPLE("*"), DIVIDE("/");

    companion object {
        private fun parseTo(operator: String): Operator {
            return values().find { it.symbol == operator } ?: throw IllegalArgumentException("잘못된 사칙연산입니다.")
        }

        fun operate(base: Int, target: Int, operator: String): Int {
            return when (parseTo(operator)) {
                PLUS -> base + target
                MINUS -> base - target
                MULTIPLE -> base * target
                DIVIDE -> base / target
            }
        }
    }
}
