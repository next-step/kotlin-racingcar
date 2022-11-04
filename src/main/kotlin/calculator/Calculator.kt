package calculator

import java.lang.IllegalArgumentException

class Calculator(
    private val cpu: CPU = CPU(),
    private val keypad: Keypad = Keypad(),
    private val monitor: Monitor = Monitor(),
    private var memory: Memory = Memory()
) {

    init {
        print("----on----")
    }

    fun pressButton(input: String?) {
        val expression: String = if (input == null) {
            keypad.pressed()
        } else {
            keypad.pressed(input)
        }
        val terms = covertExpressionToTerm(expression)
        memory.store(terms)
    }

    fun calculate(): Int {
        for (index: Int in 1 until memory.size() step 2) {
            val accumulator = memory.accumulator
            val operator = memory.fetch(index)
            val operand = memory.fetch(index + 1).toInt()

            memory.accumulator = parse(operator, accumulator, operand)
        }
        monitor.display(memory.accumulator.toString())
        return memory.accumulator
    }

    private fun covertExpressionToTerm(expression: String): List<String> {
        return expression.split(" ")
    }

    private fun parse(term: String, operand1: Int, operand2: Int): Int {
        return when (term) {
            "+" -> {
                cpu.add(operand1, operand2)
            }

            "-" -> {
                cpu.subtract(operand1, operand2)
            }

            "*" -> {
                cpu.multiply(operand1, operand2)
            }

            "/" -> {
                cpu.divide(operand1, operand2)
            }

            else -> throw IllegalArgumentException()
        }
    }
}
