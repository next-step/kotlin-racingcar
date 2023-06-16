package racingCar.view

import racingCar.domain.car.CarStatus
import racingCar.domain.race.RaceResult

class ConsoleResultView : ResultView {
    override fun drawResult(raceResult: RaceResult) {
        drawRoundResults(raceResult)
        drawWinner(raceResult.winners)
    }

    private fun drawRoundResults(raceResult: RaceResult) {

        raceResult.roundResults.forEachIndexed {
            roundNumber, raceRoundResult ->
            println("${roundNumber + 1} 라운드 결과")
            raceRoundResult.carStatuses.forEach {
                car ->
                println("[${car.key}]" + "-".repeat(car.value.position))
            }
            println()
        }
    }

    private fun drawWinner(winners: List<CarStatus>) {
        println("-- 우승자들 --")
        winners.forEach { carStatus -> print("${carStatus.id} ") }
    }
}
