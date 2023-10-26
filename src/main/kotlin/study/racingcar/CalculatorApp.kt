package study.racingcar

class CalculatorApp

fun main(args: Array<String>) {
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
            interpreter.semanticAnalysis(input)
            println("결과: ${interpreter.interpret(input)}")
        } catch (e: IllegalOperationException) {
            println(e.message)
        }
    }
}
