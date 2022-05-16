package calculator

class Calculator {

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

        val splitter = Formula(formula)
        val operations = splitter.operations
        val numbers = splitter.numbers

        val total = numbers[0]

        return numbers.drop(1).foldIndexed(total) { index, acc, num ->
            Operator.of(operations[index]).operate(acc, num)
        }
    }
}
