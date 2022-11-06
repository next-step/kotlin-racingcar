import calcualator.Number
import calcualator.Operator
import java.lang.IllegalArgumentException

class CalculatorApplication {
    fun calculate(context: String): Number {
        if (context.isBlank()) {
            throw IllegalArgumentException("빈 문자를 입력할 수 없습니다.")
        }

        var result = Number(INIT_NUMBER)
        var beforeOperator: Operator = Operator.ADD
        context.split(" ")
            .forEachIndexed { index, inputString ->
                if (index % 2 == 0) {
                    result = result.operate(beforeOperator, Number(inputString))
                } else if (index % 2 == 1) {
                    beforeOperator = Operator.of(inputString)
                }
            }
        return result
    }

    companion object {
        const val INIT_NUMBER = "0"
    }
}
