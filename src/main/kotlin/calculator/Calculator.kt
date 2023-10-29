package calculator

import java.math.BigDecimal
import java.util.Queue

object Calculator {

    fun exec(exp: Expression): BigDecimal {
        return calculate(exp.operators(), exp.operands())
    }

    private fun calculate(
        operators: Queue<Operator>,
        operands: Queue<BigDecimal>
    ): BigDecimal {
        var acc = operands.poll()
        while (!operators.isEmpty()) {
            val operator = operators.poll()
            val right = operands.poll()
            acc = operator.apply(acc, right)
        }
        return acc
    }
}
