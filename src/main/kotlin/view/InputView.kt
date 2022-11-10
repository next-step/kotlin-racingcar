package view

class InputView {
    fun getUserInput(): String {
        println("계산식을 입력하세요.")
        return readln()
    }
}
