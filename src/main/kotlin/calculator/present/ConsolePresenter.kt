package calculator.present

class ConsolePresenter {
    fun requestInput(): String? {
        print("계산식을 입력해주세요 : ")
        return readlnOrNull()
    }

    fun resultOutput(actual: Int) {
        println("계산결과 : $actual")
    }
}
