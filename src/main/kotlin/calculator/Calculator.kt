package calculator

import java.math.BigDecimal
import java.math.RoundingMode

object Calculator {
    private val operators: List<Operator> = listOf(
        Operator.PlusOperator(),
        Operator.MinusOperator(),
        Operator.MultiplyOperator(),
        Operator.DivideOperator()
    )

    fun calculate(argument: String): String {
        val result = parse(argument).execute(::getOperator)

        return format(result)
    }

    private fun format(value: BigDecimal): String {
        val down = value.setScale(0, RoundingMode.DOWN)
        return down.longValueExact().toString()
    }

    private fun parse(argument: String): CalculateExecutor {
        val arguments = argument.trim().split(" ")

        val operands = arguments.asSequence()
            .filterIndexed { idx, _ -> idx % 2 == 0 }
            .map { str -> BigDecimal.valueOf(str.toLong()) }
            .toList()

        val operators = arguments.asSequence()
            .filterIndexed { idx, _ -> idx % 2 != 0 }
            .toList()

        return CalculateExecutor(operands, operators)
    }

    private fun getOperator(operator: String): Operator {
        return operators.find { it.applicable(operator) }
            ?: throw IllegalArgumentException("Unsupported Operator [$operator]")
    }

    private class CalculateExecutor(val operands: List<BigDecimal>, val operators: List<String>) {
        init {
            if (operands.isEmpty()) {
                throw IllegalArgumentException("Must not be empty")
            }
            if (operands.size != operators.size + 1) {
                throw IllegalArgumentException("Invalid Input")
            }
        }

        fun execute(operandProvider: (input: String) -> Operator): BigDecimal {
            var lastOperand = operands[0]

            for (lastIndex in 0 until operators.size) {
                lastOperand = operandProvider(operators[lastIndex])
                    .apply(lastOperand, operands[lastIndex + 1])
            }
            return lastOperand
        }
    }
}
