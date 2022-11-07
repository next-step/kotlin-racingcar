package calculator

import calculator.common.nextToInt
import calculator.common.nextToOperator

class Calculator {

    private val parser: Parser = Parser(3)

    @Throws(Exception::class)
    fun calculate(expression: String?): Int {
        val iterator: ListIterator<String> = parser.provideElementsIterator(expression)

        var result: Int = iterator.nextToInt()
        while (iterator.hasNext()) {
            result = iterator
                .nextToOperator()
                .calculate(result, iterator.nextToInt())
        }

        return result
    }
}
