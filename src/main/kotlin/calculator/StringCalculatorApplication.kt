package calculator

fun main() {

    while (true) {
        val value = readLine()
        if (value.equals("esc")) break
        val customStringDelimiter = CustomStringDelimiter(value)
        println(Expression.calculate(customStringDelimiter.getOperands(), customStringDelimiter.getOperators()))
        println()
    }
}
