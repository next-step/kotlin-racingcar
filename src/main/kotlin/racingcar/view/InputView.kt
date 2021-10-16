package racingcar.view

class InputView {
    fun askCarNumber(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toInt() ?: 0
    }

    fun askMoveNumber(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: 0
    }
}
