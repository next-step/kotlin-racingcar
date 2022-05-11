class Calculation(private val expr: String) {
    fun run(): Int {
        isNotBlankOrThrow(expr)

        var target = 0
        var exp = ""
        expr.split(" ").forEachIndexed { i, next: String ->
            if (i == 0) {
                target = toIntOrThrow(next)
            } else if (i % 2 != 0) {
                checkExpOrThrow(next)
                exp = next
            } else {
                target = cal(target, toIntOrThrow(next), exp)
            }
        }
        return target
    }

    private fun isNotBlankOrThrow(expr: String) = require(expr.isNotBlank())

    private fun checkExpOrThrow(s: String) = require(checkExp(s))

    private fun toIntOrThrow(s: String) = s.toIntOrNull() ?: throw IllegalArgumentException()

    private fun cal(v1: Int, v2: Int, exp: String): Int {
        return when (exp) {
            "+" -> plus(v1, v2)
            "-" -> minus(v1, v2)
            "*" -> multiply(v1, v2)
            "/" -> divide(v1, v2)
            else -> throw IllegalArgumentException()
        }
    }

    private fun divide(v1: Int, v2: Int): Int {
        if (v2 == 0) throw IllegalArgumentException()
        return v1 / v2
    }

    private fun multiply(v1: Int, v2: Int) = v1 * v2

    private fun minus(v1: Int, v2: Int) = v1 - v2

    private fun plus(v1: Int, v2: Int) = v1 + v2

    private fun checkExp(exp: String): Boolean {
        return exp in listOf("+", "-", "*", "/")
    }
}
