package racingcar

class InputView {
    var carCount = 0
        private set
    var roundCount = 0
        private set

    fun excute() {
        println("자동차 대수는 몇 대인가요?")
        carCount = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        roundCount = readLine()!!.toInt()
    }
}
