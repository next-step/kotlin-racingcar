package nexstep.mission.calculator

fun String.isInteger() = this.toIntOrNull()?.let { true } ?: false
fun List<String>.removeFirst() = this.subList(1, this.size)

object Calculator {

    tailrec fun calculate(accumulator: Int = 0, operation: Operation? = null, expression: List<String>): Int =
        when (true) {
            expression.isEmpty() -> accumulator
            expression.first().isInteger() -> {
                val operand = expression.first().toInt()
                val acc = operation?.calculator?.invoke(accumulator, operand) ?: operand
                calculate(acc, null, expression.removeFirst())
            }
            else -> calculate(accumulator, Operation.find(expression.first()), expression.removeFirst())
        }
}
