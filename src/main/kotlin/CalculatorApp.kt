import java.util.Scanner

fun main() {
    print("숫자와 수식을 입력하세요 : ")
    calculation(Scanner(System.`in`).nextLine())
}

fun calculation(expr: String) {
    inputValidate(expr)

    var target = 0
    var exp = ""
    expr.split(" ").forEachIndexed { i, next: String ->
        if (i == 0) {
            target = intOrThrow(next)
        } else if (i % 2 != 0) {
            checkExpOrThrow(next)
            exp = next
        } else {
            target = cal(target, intOrThrow(next), exp)
        }
    }
    println("결과 : $target")
}

private fun inputValidate(expr: String) {
    if (expr.isNullOrBlank()) throw IllegalArgumentException()
}

private fun checkExpOrThrow(s: String) {
    if (!checkExp(s)) throw IllegalArgumentException()
}

private fun intOrThrow(s: String) = s.toIntOrNull() ?: throw RuntimeException()

private fun cal(v1: Int, v2: Int, exp: String): Int {
    return when (exp) {
        "+" -> plus(v1, v2)
        "-" -> minus(v1, v2)
        "*" -> Multiply(v1, v2)
        "/" -> divide(v1, v2)
        else -> throw IllegalArgumentException()
    }
}

private fun divide(v1: Int, v2: Int) = v1 / v2

private fun Multiply(v1: Int, v2: Int) = v1 * v2

private fun minus(v1: Int, v2: Int) = v1 - v2

private fun plus(v1: Int, v2: Int) = v1 + v2

private fun checkExp(exp: String): Boolean {
    return listOf("+", "-", "*", "/").contains(exp)
}
