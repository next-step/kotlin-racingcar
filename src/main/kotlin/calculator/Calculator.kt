package calculator

class Calculator(
    private val splitter: Splitter = Splitter()
) {
    fun calculate(input: String?): String {
        val values = splitter.split(input = input, validation = { values -> validate(values) })
        val initial = values.first()
        var result = initial.toBigDecimalOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
        var operator: Operator? = null
        for (i in 1 until values.size) {
            runCatching { values[i].toBigDecimal() }
                .onSuccess {
                    result = operator?.operate(result, it)
                        ?: throw IllegalArgumentException("연산자가 존재하지 않습니다.")
                }
                .onFailure { operator = Operator.of(values[i]) }
        }
        return result.toString()
    }

    private fun validate(values: List<String>?): List<String> {
        val nonNullValues = values ?: throw IllegalArgumentException("입력값이 null 입니다.")
        require(nonNullValues.size > 2) { "인자가 3개 이상이어야 합니다." }
        require(nonNullValues.all { it.isNotBlank() }) { "인자에 빈 공백 문자가 포함되어 있습니다." }
        return nonNullValues
    }
}
