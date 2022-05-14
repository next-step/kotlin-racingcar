package calculator

class StringCalculator {

    companion object {
        fun calculate(input: String?): String {
            require(!input.isNullOrBlank()) { "문자열 계산기의 입력값은 null이거나 빈 값일 수 없습니다. input: $input" }
            val values = input.split(VALUE_DELIMITERS)
            val iterator = values.listIterator()
            var result: Number = Number.of(iterator.next())
            while (iterator.hasNext()) {
                result = Operator.of(iterator.next()).calculate(result, Number.of(iterator.next()))
            }
            return result.parseString()
        }

        private const val VALUE_DELIMITERS = " "
    }
}

