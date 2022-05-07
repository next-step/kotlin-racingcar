package calculator.view

object InputView {
    fun printInputMessage() {
        println("수식을 입력하세요.")
    }

    fun inputExpression(): String {
        return readln()
    }
}
