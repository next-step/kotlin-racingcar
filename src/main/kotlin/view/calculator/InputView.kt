package view.calculator

class InputView private constructor() {
    companion object {
        fun inputExpression(): String {
            print("수식을 입력해주세요 : ")
            return readln()
        }
    }
}
