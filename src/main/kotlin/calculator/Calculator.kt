package calculator

import calculator.common.toOperator
import calculator.operator.Operator

class Calculator {

    private val parser: Parser = Parser(3)

    @Throws(Exception::class)
    fun calculate(expression: String?): Int {
        val elements = parser.parse(expression)
        if (parser.validate(elements).not()) throw IllegalArgumentException("element is not valid")

        // 처음 3개 추출해서 처리
        val iterator: ListIterator<String> = elements.listIterator()

        val first: Int = iterator.next().toInt()
        var operator: Operator = iterator.next().toOperator()
        var second: Int = iterator.next().toInt()

        var result: Int = operator.operate(first, second)

        // 이후에는 하나씩 처리
        while (iterator.hasNext()) {
            operator = iterator.next().toOperator()
            second = iterator.next().toInt()
            result = operator.operate(result, second)
        }

        return result
    }
}
