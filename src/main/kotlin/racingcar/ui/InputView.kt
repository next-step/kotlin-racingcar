package racingcar.ui

internal class InputView {
    fun inputCarNames(): String {
        println("주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln()
    }

    fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
