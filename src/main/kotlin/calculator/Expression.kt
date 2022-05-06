package calculator

data class Expression(
    private val numbers: List<Int>,
    private val operators: List<Operator>
) {
    init {
        require(numbers.size == operators.size + 1) {
            "숫자와 연산자의 개수가 적절하지 않습니다."
        }
    }

    fun calculate(): Int {
        return numbers.reduceIndexed { index, first, second ->
            operators[index - 1].calculate(first, second)
        }
    }
}
