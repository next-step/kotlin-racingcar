package step2_string_calculator.calculator.ui

class Receiver {
    fun run(): String {
        val expr = receive()
        if (expr.isNullOrBlank()) {
            throw IllegalArgumentException("구문에 null 혹은 빈칸은 들어갈 수 없습니다.")
        }
        return expr
    }

    fun receive(): String? {
        print("수식을 입력해 주세요 : ")
        return readLine()
    }
}
