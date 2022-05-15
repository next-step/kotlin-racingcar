package calculator

object StringCalculator {

    fun calculate(input: String?): String {
        require(!input.isNullOrBlank()) { "문자열 계산기의 입력값은 null이거나 빈 값일 수 없습니다. input: $input" }
        val values = input.split(VALUE_DELIMITERS)
        val iterator = values.iterator()
        var result: Operand = Operand.of(iterator.next())
        while (iterator.hasNext()) {
            val operator = Operator.of(iterator.next())
            result = operator.calculate(result, Operand.of(iterator.next()))
        }
        return result.parseString()
    }

    private const val VALUE_DELIMITERS = " "
}

