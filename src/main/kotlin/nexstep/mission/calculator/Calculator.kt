package nexstep.mission.calculator

fun String.isInteger() = this.toIntOrNull()?.let { true } ?: false
fun List<String>.removeFirst() = this.subList(1, this.size)

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
