package calculator

class Operators(
    private val operators: List<Operator>,
) {
    fun operate(numbers: MutableList<Int>): Int {
        var sum = numbers.removeFirst()
        operators.forEach { operator ->
            sum = operator.operate(sum, numbers.removeFirst())
        }

        return sum
    }
}
