package week1.racingcar

class RacingGame {

    private lateinit var cars: List<Car>
    private var timesToRace = 0

    fun start() {
        InputView().startInput().also {
            this@RacingGame.apply {
                cars = it.cars.map { Car(it) }
                timesToRace = it.timesToRace
            }
            race()
        }
    }

    private fun race() {
        val resultView = ResultView()
        (0 until timesToRace).forEach { _ ->
            cars.forEach {
                if (isPossibleToDrive()) {
                    it.go()
                }
            }
            resultView.run {
                showResult(cars)
                showWinner(getWinners(cars))
            }
        }
    }

    private fun isPossibleToDrive() = RandomUtils.getRandomDigit() > 4

    private fun getWinners(cars: List<Car>): List<String> {
        val farthestMileage = getFarthestMileage(cars)
        return cars.filter { it.mileage == farthestMileage }.map { it.name }
    }

    private fun getFarthestMileage(cars: List<Car>): Int {
        return cars.map { it.mileage }.maxOf { it }
    }
}

fun main() {
    RacingGame().start()
}