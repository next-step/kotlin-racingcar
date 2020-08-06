package racingCar.domain

import racingCar.view.OutputView

class RacingCars(private val carNames: List<String>) {

    init {
        generateCar(carNames)
    }

    private fun generateCar(carNames: List<String>) {
        participant = carNames.map { Car(it) }
    }

    fun startRacing(trialCount: Int): List<Car> {

        repeat(trialCount) { index ->
            println("${index + 1} 번째 경주")
            tryMove()
        }
        return participant
    }

    private fun tryMove() {
        var randomNum: Int

        participant.forEach {
            randomNum = RandomGenerator.getRandomNumber()
            it.changeStateRacingCar(randomNum)
        }
        OutputView.getCarRacingResult(participant)
    }

    fun getRacingWinner(racingCars: List<Car>): String {
        val maxDistance = racingCars.map { it.distance }.max()
        return racingCars.filter { it.distance == maxDistance }.joinToString { it.name }
    }

    companion object {
        var participant = listOf<Car>()
    }
}
