package step2

import step2.calculable.Calculable
import step2.calculable.strategy.AddCalculableStrategy
import step2.calculable.strategy.DivideCalculableStrategy
import step2.calculable.strategy.ModCalculableStrategy
import step2.calculable.strategy.MultiplyCalculableStrategy
import step2.calculable.strategy.SubtractCalculableStrategy

enum class Operator(private val operator: String, private val calculable: Calculable) {
    PLUS("+", AddCalculableStrategy()),
    MINUS("-", SubtractCalculableStrategy()),
    MULTIPLICATION("*", MultiplyCalculableStrategy()),
    DIVISION("/", DivideCalculableStrategy()),
    REMAINDER("%", ModCalculableStrategy())
    ;

    companion object {
        fun values(operator: String): Operator = values().asSequence()
            .find { it.operator == operator }
            ?: throw IllegalArgumentException()
    }

    fun calculate(x: Int, y: String) = calculate(x, Integer.valueOf(y))
    private fun calculate(x: Int, y: Int) = calculable.calculate(x, y)
}
