package calculator

class StringCalculator(private val input: String?) {
    fun run(): Int {
        require(!input.isNullOrBlank()) { "입력값은 공백일 수 없습니다" }
        val splitted = splitter(input, " ")

        return calculate(splitted)
    }

    private fun calculate(splittedInput: List<String>): Int {
        return splittedInput.foldIndexed(Pair(0, Operator.PLUS)) { idx, pair, element ->
            if (isEvenIndex(idx)) {
                val rightTerm = toIntOrThrow(element)
                Pair(calculate(pair.first, rightTerm, pair.second), pair.second)
            } else {
                Pair(pair.first, element.convertToOperatorEnum())
            }
        }.first
    }

    private fun isEvenIndex(idx: Int) = idx % 2 == 0

    private fun splitter(input: String, delimiter: String): List<String> = input.split(delimiter)

    private fun toIntOrThrow(element: String): Int {
        return element.toIntOrNull() ?: throw IllegalArgumentException("$element 는 정수가 아닙니다")
    }

    private fun calculate(leftTerm: Int, rightTerm: Int, operator: Operator): Int {
        return when (operator) {
            Operator.PLUS -> leftTerm + rightTerm
            Operator.MINUS -> leftTerm - rightTerm
            Operator.MULTIPLY -> leftTerm * rightTerm
            Operator.DIVIDE -> if (rightTerm == 0) {
                throw IllegalArgumentException("/ 뒤에는 0이 올 수 없습니다")
            } else {
                leftTerm / rightTerm
            }
        }
    }
}
