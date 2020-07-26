package step2

import java.util.regex.Pattern

class CalculatorUtil {
    companion object {

        private const val DELIMITER = " "
        private val OPERATOR_REGEX = Pattern.compile("[+|\\-|*|/]")
        private val NON_NUMERIC_REGEX = Pattern.compile("[^0-9]")

        fun validateAndReturn(string: String): List<String> {
            val split = string.split(DELIMITER)
            validateEmptyData(string)
            validateInputSize(split)
            checkInputOperator(split)
            checkInputNumber(split)
            return split
        }

        fun checkInputOperator(split: List<String>) {
            for (s in split.slice(1..split.lastIndex step 2)) {
                if (!OPERATOR_REGEX.matcher(s).matches()) {
                    throw IllegalArgumentException("허용되지 않은 연산자가 있습니다.")
                }
            }
        }

        fun checkInputNumber(split: List<String>) {
            for (s in split.slice(0..split.lastIndex step 2)) {
                if (NON_NUMERIC_REGEX.matcher(s).matches()) {
                    throw IllegalArgumentException("숫자 타입이 아닌 문자가 있습니다.")
                }
            }
        }

        fun validateEmptyData(string: String) {
            if (string.isBlank()) {
                throw java.lang.IllegalArgumentException("input data 가 비어있습니다.")
            }
        }

        fun validateInputSize(split: List<String>) {
            if (split.size < 2 || split.size % 2 == 0) {
                throw IllegalArgumentException("잘못된 포멧입니다")
            }
        }

        fun parser(
            splitString: MutableList<String>,
            sortedString: MutableList<String>
        ) {
            sortedString[1] = splitString.removeAt(0)
            sortedString[0] = splitString.removeAt(0)
            sortedString[2] = splitString.removeAt(0)
        }
    }
}
