package racing

import racing.domain.Racing
import racing.model.Car
import racing.model.CarName
import racing.model.RacingResult
import racing.model.RoundCount

class RacingGame(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val racingCarGarage: RacingCarGarage,
    private val racing: Racing,
    private val racingRecordBoard: RacingRecordBoard,
) {

    fun getRaceInfo(): Pair<List<CarName>, RoundCount> {
        val (drivers, roundCount) = inputView.getRaceInfo()
            .let { (drivers, roundCount) ->
                drivers.map { driver -> CarName(driver) } to (roundCount?.let { RoundCount(it) })
            }
        require(drivers.isNotEmpty()) { "유효한 자동차 이름이 아닙니다." }
        requireNotNull(roundCount) { "유효한 시도횟수 입력 값이 아닙니다." }
        return drivers to roundCount
    }


    fun start(carNames: List<CarName>, roundCount: RoundCount) {
        setUpCarWithDrivers(carNames)
        raceAllRound(roundCount)
    }

    fun getRacingResultAndWinners(): Pair<List<RacingResult>, List<CarName>> =
        racingRecordBoard.results to racingRecordBoard.winners

    fun printResult(racingResult: List<RacingResult>, winners: List<CarName>) {
        resultView.printRaceResult(results = racingResult, winners = winners)
    }

    private fun setUpCarWithDrivers(carNames: List<CarName>): Unit =
        racingCarGarage.setCarsWithNames(carNames = carNames)

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
