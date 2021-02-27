package calculator.userinterface

class Console : UserInterface {

    override fun showInput() {
        println("계산식을 입력 해주세요.")
    }

    override fun inputMathExpression(): String {
        return readLine() ?: ""
    }

    override fun showResult(result: Int) {
        println("결과: $result")
    }
}
