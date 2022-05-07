package step2

class ExpressionParser(private val inputStr: String) {

    private val validArgRegex = Regex("[\\d */+-]")
    private val operatorRegex = Regex("[+*/-]")

    init {
        require(validArgRegex.containsMatchIn(inputStr)) {
            "숫자 혹은 사칙연산 기호가 아닌 입력이 존재합니다"
        }
    }

    fun getOperands(): List<Double> =
        operatorRegex.split(inputStr)
            .map { it.toDouble() }

    fun getOperators(): List<String> = listOf("+") +
        operatorRegex.findAll(inputStr)
            .map { it.value }
            .toList()
}