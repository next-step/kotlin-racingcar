package calculator

fun main(args: Array<String>) {
    val calculator = Calculator()

    while (true) {
        println("계산식을 입력하세요. 예: 1 + 2 * 3")
        val input = readlnOrNull()
        if (input == null) {
            println("종료합니다.")
            break
        }
        try {
            println(calculator.calculate(input))
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
