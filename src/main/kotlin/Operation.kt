class Operation {
    companion object {
        fun operation(x: String, y: String, o: Char): Int {
            val operator = Operator.values().find { it.operator == o }
                ?: throw IllegalArgumentException("+ - * / 를 제외한 다른 연산자가 포함되어 있습니다.")

            return when (operator) {
                Operator.PLUS -> add(x, y)
                Operator.MINUS -> sub(x, y)
                Operator.MULTIPLY -> mul(x, y)
                Operator.DIVISION -> div(x, y)
            }
        }

        private fun add(x: String, y: String): Int {
            return Integer.valueOf(x) + Integer.valueOf(y)
        }

        private fun sub(x: String, y: String): Int {
            return Integer.valueOf(x) - Integer.valueOf(y)
        }

        private fun mul(x: String, y: String): Int {
            return Integer.valueOf(x) * Integer.valueOf(y)
        }

        private fun div(x: String, y: String): Int {
            return Integer.valueOf(x) / Integer.valueOf(y)
        }
    }
}

enum class Operator(val operator: Char) {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVISION('/')
}
