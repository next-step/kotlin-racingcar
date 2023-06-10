package step2

interface ExpressionParser {
    // 코틀린에서는 인터페이스에 프로퍼티도 정의할 수 있다.
    // 단, public만 가능함에 주의

    // val operators: List<Operator>
    // val operands: List<Int>

    fun parse(expression: String): Expression
}
