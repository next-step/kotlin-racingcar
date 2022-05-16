package calculator

class StringCalculator(private val input: String?) {
    fun run(): Int {
        require(!input.isNullOrBlank()) { "입력값은 공백일 수 없습니다" }
        val splitted = splitter(input, " ")
        var operator = "+"

        return splitted.foldIndexed(0) { idx, sum, element ->
            if (isEvenIndex(idx)) {
                val rightTerm = toIntOrThrow(element)
                calculate(sum, rightTerm, operator)
            } else {
                require(isValidOperator(element))
                operator = element
                sum
            }
        }
    }

    private fun isEvenIndex(idx: Int) = idx % 2 == 0

    private fun splitter(input: String, delimiter: String): List<String> = input.split(delimiter)

    private fun isValidOperator(element: String): Boolean {
        return element in listOf("+", "-", "*", "/")
    }

    private fun toIntOrThrow(element: String): Int {
        return element.toIntOrNull() ?: throw IllegalArgumentException("$element 는 정수가 아닙니다")
    }

    private fun calculate(leftTerm: Int, rightTerm: Int, operator: String): Int {
        return when (operator) {
            "+" -> leftTerm + rightTerm
            "-" -> leftTerm - rightTerm
            "*" -> leftTerm * rightTerm
            "/" -> if (rightTerm == 0) {
                throw IllegalArgumentException("/ 뒤에는 0이 올 수 없습니다")
            } else { leftTerm / rightTerm }

            else -> throw IllegalArgumentException("$operator 는 잘못된 연산자입니다")
        }
    }
}
