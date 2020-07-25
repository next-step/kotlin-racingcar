package calculator

enum class InputType {
    NUMBER,
    OPERATOR,
    NONE;

    companion object {

        fun of(value: String) = when {
            isNumber(value) -> NUMBER
            isOperator(value) -> OPERATOR
            else -> NONE
        }

        private fun isNumber(value: String) = value.toDoubleOrNull() != null

        private fun isOperator(value: String) = Operation.of(value) != null
    }
}
