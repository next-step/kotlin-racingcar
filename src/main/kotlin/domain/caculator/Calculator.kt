package domain.caculator

class Calculator {
    fun calculate(expressions: List<Pair<Operator, Int>>) = expressions.fold(0) { number1, (operator, number2) ->
        operator.calculate(number1, number2)
    }
}
