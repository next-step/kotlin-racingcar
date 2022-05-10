package calculator

fun main() {
    val value = readLine()
    val customStringDelimiter = CustomStringDelimiter(value)
    println(Expression.calculate(customStringDelimiter.getOperands(), customStringDelimiter.getOperators()))
}
