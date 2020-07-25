import java.math.BigDecimal

class Calculator {
    fun checkValidation(mInputs: String?): InputValidation {
        if (mInputs == null || mInputs.isEmpty()) return InputValidation.EMPTY_STRING
        val symbols = listOf("+", "-", "*", "/")
        var symbolCount: Int = 0
        var numberCount: Int = 0
        // 기호가 - 일때 계산기호가 이닌 수 자체가 음수일 어떻게 할 것인가
        val inputs: List<String> = mInputs.split(" ")
        var needToCheckZero: Boolean = false
        for (input: String in inputs) {
            try {
                input.toBigDecimal()
                numberCount++
                if (needToCheckZero && input.toBigDecimal() == BigDecimal.ZERO) return InputValidation.ZERO_AFTER_DIVIDE
                if (numberCount > 0 && numberCount - 1 != symbolCount) return InputValidation.INVALID_NUMBER_SYMBOL_ORDER
                needToCheckZero = false
            } catch (e: NumberFormatException) {
                if (input.isEmpty() || input.length > 1) {
                    return InputValidation.BLANK_ERROR
                } else if (symbols.contains(input) && input.length == 1) {
                    symbolCount++
                    if (input == "/") needToCheckZero = true
                    continue
                } else if (!symbols.contains(input) && input.length == 1) {
                    return InputValidation.CALCULATOR_SYMBOL
                }
            }
        }
        return InputValidation.SUCCESS
    }

    fun calculate(mInputs: String): String {
        val inputs: List<String> = mInputs.split(" ")
        var result: String = inputs[0]
        var symbol: String = inputs[0]
        for (input: String in inputs) {
            try {
                if (input != result) when (symbol) {
                    "+" -> result = add(result, input)
                    "-" -> result = subtract(result, input)
                    "*" -> result = multiply(result, input)
                    "/" -> result = divide(result, input)
                }
                input.toBigDecimal()
            } catch (e: NumberFormatException) {
                symbol = input
            }
        }
        return result
    }

    fun add(v1: String, v2: String): String = v1.toBigDecimal().plus(v2.toBigDecimal()).toPlainString()

    fun subtract(v1: String, v2: String): String = v1.toBigDecimal().subtract(v2.toBigDecimal()).toPlainString()

    fun multiply(v1: String, v2: String): String = v1.toBigDecimal().multiply(v2.toBigDecimal()).toPlainString()

    fun divide(v1: String, v2: String): String =
        (v1.toBigDecimal().divide(v2.toBigDecimal(), 8, BigDecimal.ROUND_HALF_EVEN)).stripTrailingZeros()
            .toPlainString()
}
