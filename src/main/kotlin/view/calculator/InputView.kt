package view.calculator

object InputView {
    fun inputExpression(): String {
        print("수식을 입력해주세요 : ")
        return readln()
    }
}
