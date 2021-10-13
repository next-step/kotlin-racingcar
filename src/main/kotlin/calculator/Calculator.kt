package calculator

/**
 * 계산기는 사칙연산(명령)을 수행할 수 있는 객체들과 협력하여 주어진 계산을 수행한다.
 * 표준, 공학용, 프로그래머용 계산기가 다른 것 처럼 하나의 계산기가 동작할 수 있는 연산 방법을 넣어주는 형태로 설계
 */
abstract class Calculator(operators: List<Operator>) {

    constructor(vararg operators: Operator) : this(operators.toList())

    private val operators: Map<Symbol, Operator> = mutableMapOf<Symbol, Operator>().apply {
        operators.forEach { operator ->
            val symbol = operator.symbol
            if (containsKey(symbol)) {
                throw IllegalArgumentException("$symbol is already added")
            }
            put(symbol, operator)
        }
    }

    protected fun findOperator(symbol: Symbol): Operator? = operators[symbol]

    abstract fun calculate(input: String?): Int
}
