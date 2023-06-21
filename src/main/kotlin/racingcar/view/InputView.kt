package racingcar.view

class InputView {

    fun inputCarsNames(): String {
        printIputCarNamesMessage()
        return readln()
    }

    private fun printIputCarNamesMessage() {
        println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun inputRoundCount(): Int {
        printInputTryCountMessage()
        return readln().toInt()
    }

    private fun printInputTryCountMessage() {
        println("시도할 회수는 몇 회 인가요?")
    }
}
