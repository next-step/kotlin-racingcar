package calculator

data class Expression(
    private val numbers: List<Int>,
    private val operators: List<Operator>
) {
    init {
        // TODO: Q. 주 생성자에서 객체 생성에 대한 검증이 필요한 경우 어떤 방법이 좋을까요?
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
