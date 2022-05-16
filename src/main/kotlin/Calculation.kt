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
                target = compute(target, toIntOrThrow(next), exp)
            }
        }
        return target
    }

    private fun checkNotBlankOrThrow(expr: String) = require(expr.isNotBlank())

    private fun checkExpOrThrow(s: String) = require(checkExp(s))

    private fun toIntOrThrow(s: String) = s.toIntOrNull() ?: throw IllegalArgumentException()

    private fun compute(v1: Int, v2: Int, exp: String) = Operation.of(exp).compute(v1, v2)

    private fun checkExp(exp: String): Boolean {
        return Operation.of(exp) in Operation.values() && Operation.of(exp) != Operation.NONE
    }
}
