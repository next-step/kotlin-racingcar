package study.calculator

class CalculatorApp

fun main() {
    val parser = Parser()
    val interpreter = Interpreter(parser)

    while (true) {
        print("계산식을 입력해주세요. (ex. 숫자 / 연산자 / 숫자 / 연산자 / 숫자): ")
        val input = readLine() ?: throw IllegalArgumentException()

        if (input == "exit") {
            println("프로그램을 종료합니다.")
            break // "exit" 입력 시 반복문을 종료
        }

        try {
            println("결과: ${interpreter.interpret(input)}")
        } catch (e: Exception) {
            println("[$e] 입력 문자열을 확인해주세요.")
        }
    }
}
