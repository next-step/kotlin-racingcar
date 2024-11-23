package racingcar.calculator

/** 전처리: 연산자 배열과 숫자 배열로 분리한다 */
class PreProcess {
    companion object {
        private const val SPACE = " "
        private val validOperator = "+-*/"

        fun splitBySpace(s: UserInputString): List<String> {
            return s.getUserInputString().split(SPACE)
        }

        fun extractNumbers(input: List<String>): List<Double> {
            return input.filter { validOperator.contains(it).not() }
                .map { it.toDouble() }
        }

        fun extractOperators(input: List<String>): List<String> {
            val onlyCharacters = input.filter { !it.matches(Regex("\\d+")) }
            val onlyValidOperator = onlyCharacters.all(validOperator::contains)
            if (!onlyValidOperator) {
                throw IllegalArgumentException("허용하는 연산자는 +, -, *, / 입니다")
            }
            return input.filter { validOperator.contains(it) }
        }
    }
}
