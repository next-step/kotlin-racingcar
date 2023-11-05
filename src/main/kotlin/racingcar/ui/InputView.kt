package racingcar.ui

class InputView {

    var carSize = 0
        private set
    var attemptSize = 0
        private set

    fun show() {
        println("자동차 대수는 몇 대인가요?")
        carSize = readln().toInt()

        println("시도할 횟수는 몇 회인가요?")
        attemptSize = readln().toInt()
    }
}
