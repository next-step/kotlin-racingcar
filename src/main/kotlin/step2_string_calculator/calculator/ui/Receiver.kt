package step2_string_calculator.calculator.ui

open class Receiver {
    fun run(): String {
        val expr = receive()
        require(!expr.isNullOrBlank()) { "구문에 null 혹은 빈칸은 들어갈 수 없습니다." }
        return expr
    }

    open fun receive(): String? {
        print("수식을 입력해 주세요 : ")
        return readLine()
    }
}
