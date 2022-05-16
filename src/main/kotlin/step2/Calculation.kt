package step2

class Calculation(private val expr: String) {
    fun run(): Int {
        checkNotBlankOrThrow(expr)

        var target = 0
        var exp = ""
        expr.split(" ").forEachIndexed { i, next: String ->
            if (i == 0) {
                target = toIntOrThrow(next)
            } else if (i % 2 != 0) {
                checkExpOrThrow(next)
                exp = next
            } else {
                target = Operation.of(exp).compute(target, toIntOrThrow(next))
            }
        }
        return target
    }

    private fun checkNotBlankOrThrow(expr: String) = require(expr.isNotBlank())

    private fun checkExpOrThrow(s: String) = require(Operation.contains(s))

    private fun toIntOrThrow(s: String) = s.toIntOrNull() ?: throw IllegalArgumentException()
}
