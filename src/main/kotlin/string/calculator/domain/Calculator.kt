package string.calculator.domain

object Calculator {
    fun calculate(numbers: MutableList<Long>, operators: MutableList<Operator>): Long {
        var result = numbers.removeFirst()

        for (i in operators.indices) {
            result = operators[i].operate(result, numbers[i])
        }

        return result
    }
}
