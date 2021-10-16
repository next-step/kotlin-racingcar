package calculator

object OperatorFactory {

    private val binaries = listOf(Plus, Minus, Multiply, Divide)

    fun getBinaryFor(literal: String): BinaryOperator {
        return binaries.find { it.canHandle(literal) }
            ?: throw IllegalArgumentException("${literal}은 지원하는 연산자가 아닙니다.")
    }
}
