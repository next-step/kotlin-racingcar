fun main(args: Array<String>) {
    println("계산기 프로그램을 시작합니다.")
    println("숫자와 연산자를 입력하세요")
    val input = readLine() ?: throw IllegalArgumentException("입력이 잘못되었습니다.")

    val calculator = Calculator()
    val calculatorController = CalculatorController(calculator)

    val result = calculatorController.calc((input))
    println(result)
}
