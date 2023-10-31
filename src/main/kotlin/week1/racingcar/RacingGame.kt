package week1.racingcar

class RacingGame {

    private var numberOfCars = 0
    private var timesToRace = 0

    fun start() {
        InputView().startInput().also {
            this@RacingGame.apply {
                numberOfCars = it.numberOfCars
                timesToRace = it.timesToRace
            }
            race()
        }
    }

    private fun race() {
        val resultView = ResultView()
        val cars = List(numberOfCars) { Car() }
        (0 until timesToRace).forEach { _ ->
            cars.forEach {
                if (isPossibleToDrive()) {
                    it.go()
                }
            }
            resultView.showResult(cars)
        }
    }

    private fun isPossibleToDrive() = RandomUtils.getRandomDigit() > 4
}

fun main() {
    RacingGame().start()
}