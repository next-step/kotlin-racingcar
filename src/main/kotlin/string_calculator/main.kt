package string_calculator

fun main(args: Array<String>) {
    print("문자열을 입력해 주세요:")
    val input = readLine()

    CalculatorService().verifyExpression(input)

    val expression = input!!.trim().split(" ")
    println("답 : " + CalculatorService().calculator(expression))
}
