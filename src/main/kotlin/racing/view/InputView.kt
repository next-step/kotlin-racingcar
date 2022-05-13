package racing.view

object InputView {

    fun printCarNamesInputMessage() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printTryCountInputMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun inputCarNames(): String {
        return readln()
    }

    fun inputTryCount(): Int {
        return readln().toInt()
    }
}
