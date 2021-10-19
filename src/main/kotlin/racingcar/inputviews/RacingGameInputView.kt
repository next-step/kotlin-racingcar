package racingcar.inputviews

class RacingGameInputView : InputView {
    override fun receiveInput(): GameInput {
        val numberOfCars = receiveNumberOfCars()
        val numberOfRounds = receiveNumberOfRounds()

        return GameInput(numberOfCars, numberOfRounds)
    }

    private fun receiveNumberOfCars(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return receiveInt()
    }

    private fun receiveNumberOfRounds(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return receiveInt()
    }

    private fun receiveInt(): Int {
        return readLine()!!.toInt()
    }
}
