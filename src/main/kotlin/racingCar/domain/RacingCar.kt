package racingCar.domain

import racingCar.view.OutputView

class RacingCar(private val carNames: List<String>) {

    init {
        generateCar(carNames)
    }

    private fun generateCar(carNames: List<String>) {
        racingCars = carNames.map { Car(it) } as MutableList<Car>
    }

    fun startRacing(trialCount: Int): List<Car> {

        repeat(trialCount) { index ->
            println("${index + 1} 번째 경주")
            tryMove()
        }
        return racingCars
    }

    private fun tryMove() {
        var randomNum: Int

        racingCars.forEach {
            randomNum = RandomGenerator.getRandomNumber()
            it.changeStateRacingCar(randomNum)
        }
        OutputView.getCarRacingResult(racingCars)
    }

    companion object {
        var racingCars = mutableListOf<Car>()
    }
}
