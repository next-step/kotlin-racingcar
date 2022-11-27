package racing

import racing.domain.Racing
import racing.model.Car
import racing.model.CarName
import racing.model.RacingResult
import racing.model.RoundCount

class RacingGame(
    private val racingCarGarage: RacingCarGarage,
    private val racing: Racing,
    private val racingRecordBoard: RacingRecordBoard,
) {

    fun start(roundCount: RoundCount) {
        raceAllRound(roundCount)
    }

    fun getRacingResultAndWinners(): Pair<List<RacingResult>, List<CarName>> =
        racingRecordBoard.results to racingRecordBoard.winners

    private fun raceAllRound(roundCount: RoundCount) {
        repeat(roundCount.value) {
            val raceResult = race()
            racingRecordBoard.add(raceResult)
        }
    }

    private fun race(): List<Car> = racingCarGarage.cars
        .map(racing::driveCar)
        .also(racingCarGarage::parkCars)
}
