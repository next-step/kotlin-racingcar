package step2

class StringCalculator(private val inputStr: String) {

    private val validArgRegex = Regex("[\\d */+-]")
    private val operatorRegex = Regex("[+*/-]")
    private var processedInputStr: String

    init {
        require(inputStr.isNotEmpty()) {
            "inputStr must not be null or empty"
        }

        require(validArgRegex.containsMatchIn(inputStr)) {
            "숫자 혹은 사칙연산 기호가 아닌 입력이 존재합니다"
        }

        processedInputStr = inputStr.replace(" ", "")
    }

    fun result(): Double {
        val operands = operandPreProcessing()
        val operators = operatorPreProcessing()

        require(operands.size == operators.size) {
            "피연산자의 수(${operands.size})와 연산자 수(${operators.size - 1})가 적합하지 않습니다 " +
                    "ex. 피연산자 수 == 연산자 수 + 1"
        }

        return calculate(0.0, operators, operands)
    }

    private fun calculate(accum: Double, operators: List<String>, operands: List<Double>): Double =
        if (operands.isEmpty()) {
            accum
        } else {
            calculate(
                operate(operators.first(), accum, operands.first()),
                operators.drop(1),
                operands.drop(1)
            )
        }

    private fun operate(operator: String, operand1: Double, operand2: Double): Double =
        when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> throw IllegalArgumentException("$operator 는 적합한 연산자가 아닙니다. ex) +, -, /, *")
        }

    private fun operandPreProcessing(): List<Double> =
        operatorRegex.split(processedInputStr)
            .map { it.toDouble() }

    private fun operatorPreProcessing(): List<String> = listOf("+") +
        operatorRegex.findAll(processedInputStr)
            .map { it.value }
            .toList()
}