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
        val intInput = readLine()!!.toInt()
        validateInput(intInput)
        return intInput
    }

    @Throws(IllegalArgumentException::class)
    private fun validateInput(input: Int) {
        if (input < 0) {
            throw IllegalArgumentException("입력은 0 보다 큰 정수이어야 합니다.")
        }
    }
}
