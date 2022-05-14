package calculator

class Calculator {
    private fun calculateByOperation(operation: String, total: Float, num: Float): Float {
        when (operation) {
            "+" -> {
                return total + num
            }
            "-" -> {
                return total - num
            }
            "*" -> {
                return total * num
            }
            "/" -> {
                return total / num
            }
            else -> {
                throw IllegalArgumentException("옵바른 사칙연산 기호가 아닙니다. (사용 가능 연산: + - * / )")
            }
        }
    }

    private fun isIllegalArgument(formula: String): Boolean {
        return formula.split(" ").size < 3
    }

    fun calculate(formula: String?): Float {
        if (formula.isNullOrEmpty()) {
            throw IllegalArgumentException("입력값을 입력해주세요.")
        }

        if (isIllegalArgument(formula)) {
            throw IllegalArgumentException("올바른 계산식이 아닙니다. 공백을 포함하여 다시 입력해주세요.")
        }

        val splitter = Splitter(formula)
        val operations = splitter.operations
        val numbers = splitter.numbers

        val total = numbers[0]

        return numbers.drop(1).foldIndexed(total) { index, acc, num ->
            calculateByOperation(
                operations[index],
                acc,
                num
            )
        }
    }
}
