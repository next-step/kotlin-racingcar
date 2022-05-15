package calculator

fun main() {
    print("연산을 수행할 문자열을 입력해주세요: ")
    val input = readLine()
    print("연산 결과 : ${StringCalculator.calculate(input)}")
}
