package calculator.domain

data class Operand(val number: Double) {

    companion object {
        fun from(input: String): Operand = Operand(getValidateValue(input))

        private fun getValidateValue(number: String): Double {
            return number.toDoubleOrNull() ?: throw IllegalArgumentException("올바르지 않은 피연산자 타입입니다")
        }
    }
}
