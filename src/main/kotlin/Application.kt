import calcualator.Calculator
import calcualator.Operator
import java.lang.IllegalArgumentException

class Application {
    fun calculate(context: String): Calculator {
        if (context.isBlank()) {
            throw IllegalArgumentException("빈 문자를 입력할 수 없습니다.")
        }

        var result = Calculator(INIT_NUMBER)
        var beforeOperator: Operator = Operator.ADD
        context.split(" ")
            .forEachIndexed { index, s ->
                if (index % 2 == 0) {
                    result = result.operate(beforeOperator, Calculator(s))
                } else if (index % 2 == 1) {
                    beforeOperator = Operator.of(s)
                }
            }
        return result
    }

    companion object {
        const val INIT_NUMBER = "0"
    }
}
