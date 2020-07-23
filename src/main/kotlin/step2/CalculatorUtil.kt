package step2

class CalculatorUtil {
    companion object {

        private const val Delimiter = " "

        fun validateAndReturn(string: String): List<String> {
            val split = string.split(Delimiter)
            validateInputSize(split)
            checkInputOperator(split)
            checkInputNumber(split)
            return split
        }

        fun checkInputOperator(split: List<String>) {
            for (s in split.slice(1..split.lastIndex step 2)) {
                if (!s.matches("[+|\\-|*|/]".toRegex()))
                    throw IllegalArgumentException("허용되지 않은 연산자가 있습니다.")
            }
        }

        fun checkInputNumber(split: List<String>) {
            for (s in split.slice(0..split.lastIndex step 2)) {
                if (s.matches("[^0-9]".toRegex()))
                    throw IllegalArgumentException("숫자 타입이 아닌 문자가 있습니다.")
            }
        }

        fun validateInputSize(split: List<String>) {
            if (split.isEmpty())
                throw IllegalArgumentException("input data 가 비어있습니다.")
            if (split.size % 2 == 0)
                throw IllegalArgumentException("잘못된 포멧입니다")
        }
    }

}
