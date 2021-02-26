package step2

import step2.ui.inputExpression
import step2.ui.show

class Calculator {

    fun run() {
        val expression = Expression(inputExpression())
        show(expression.calculate())
    }
}
