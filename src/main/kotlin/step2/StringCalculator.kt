package step2

class StringCalculator {
	fun calculate(expression: String): Int {
		validateInput(expression)

		val tokens = expression.trim().split(" ")

		var result = tokens[0].toInt()

		var i = 1
		while (i < tokens.size - 1) {
			val operator = tokens[i]
			val number = tokens[i + 1].toInt()

			result = performOperation(result, operator, number)
			i += 2
		}

		return result
	}

	private fun validateInput(expression: String) {
		if (expression.isBlank()) {
			throw IllegalArgumentException("입력값이 null이거나 빈 문자열입니다.")
		}

		val tokens = expression.trim().split(" ")
		if (tokens.size < 3 || tokens.size % 2 == 0) {
			throw IllegalArgumentException("올바르지 않은 수식 형식입니다.")
		}

		tokens.filterIndexed { index, _ -> index % 2 == 1 }
			.forEach { operator ->
				if (operator !in validOperators) {
					throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
				}
			}
	}

	private fun performOperation(a: Int, operator: String, b: Int): Int {
		return when (operator) {
			"+" -> a + b
			"-" -> a - b
			"*" -> a * b
			"/" -> if (b != 0) a / b else throw IllegalArgumentException("0으로 나눌 수 없습니다.")
			else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
		}
	}

	companion object {
		private val validOperators = setOf("+", "-", "*", "/")
	}
}
