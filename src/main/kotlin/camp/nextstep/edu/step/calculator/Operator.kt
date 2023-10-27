package camp.nextstep.edu.step.calculator

enum class Operator(
    private val operatorSymbol: String,
    private val calculateNumbers: (Long, Long) -> Long
) {
    PLUS("+", { leftNum, rightNum -> leftNum + rightNum }),
    MINUS("-", { leftNum, rightNum -> leftNum - rightNum }),
    MULTIPLY("*", { leftNum, rightNum -> leftNum * rightNum }),
    DIVIDE("/", { leftNum, rightNum ->
        require(rightNum != 0L) { "0으로 나눌 수 없습니다." }
        leftNum / rightNum
    });

    fun calculate(a: Long, b: Long): Long {
        return calculateNumbers(a, b)
    }

    companion object {
        fun of(operatorSymbol: String): Operator {
            return values().find { it.operatorSymbol == operatorSymbol }
                ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
