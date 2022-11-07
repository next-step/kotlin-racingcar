package nexstep.mission.calculator

fun String.isInteger() = this.toIntOrNull() != null
fun List<String>.removeFirst() = this.takeLast(this.size - 1)

object Calculator {

    tailrec fun calculate(accumulator: Int = 0, operator: Operator? = null, expression: List<String>): Int =
        when (true) {
            expression.isEmpty() -> accumulator
            expression.first().isInteger() -> {
                val operand = expression.first().toInt()
                val acc = operator?.operate?.invoke(accumulator, operand) ?: operand
                calculate(acc, null, expression.removeFirst())
            }
            else -> calculate(accumulator, Operator.find(expression.first()), expression.removeFirst())
        }
}
