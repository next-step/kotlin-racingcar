package calculator

class EquationValidator {

    fun validateEquation(equation: String) {
        if (equation.isBlank()) {
            throw IllegalArgumentException("빈 값은 입력할 수 없습니다.")
        }
    }
}
