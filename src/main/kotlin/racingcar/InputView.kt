package racingcar

class InputView(
    private val carNumberQuestion: String = "자동차 대수는 몇 대인가요?",
    private val trialsQuestion: String = "시도할 횟수는 몇 회인가요?"
) {
    fun startRacing(): Racing {
        println(carNumberQuestion)
        val numberOfCars = readLine()!!.toInt()

        println(trialsQuestion)
        val trials = readLine()!!.toInt()

        return Racing(trials, generateCars(numberOfCars))
    }

    private fun generateCars(numberOfCars: Int): List<Car> {
        return (1..numberOfCars).map { Car(RacingEngine()) }
    }
}
