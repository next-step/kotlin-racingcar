package racingcar

object InputView {
    fun receiveInput(): RacingCarGame {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCar = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val numberOfTrial = readLine()!!.toInt()

        return RacingCarGame(numberOfCar, numberOfTrial)
    }
}
