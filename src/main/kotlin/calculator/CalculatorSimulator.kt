package calculator

fun main() {
    print("계산식을 입력해주세요 ->")
    val expression = readln()
    val stringCalculator = StringCalculator()
    val result = stringCalculator.calculateExpression(expression)

    println("입력한 식의 결과입니다 -> $result")
}
