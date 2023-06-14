package racing_car.view

import racing_car.domain.car.CarStatus
import racing_car.domain.race.RaceResult
import racing_car.domain.race.RaceRoundResult

class ConsoleResultView : ResultView {
    override fun drawResult(raceResult: RaceResult) {
        drawRoundResults(raceResult)
        drawWinner(raceResult.roundResults.last())
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

    private fun drawWinner(lastRound: RaceRoundResult) {
        val winnerList: MutableList<CarStatus> = mutableListOf()
        var curMaxPosition = 0
        for (elem in lastRound.carStatuses) {
            if (curMaxPosition < elem.value.position) {
                winnerList.clear()
                winnerList.add(elem.value)
                curMaxPosition = elem.value.position
            }
            else if (curMaxPosition == elem.value.position) {
                winnerList.add(elem.value)
            }
        }

        println("우승자 목록")
        winnerList.forEach { carStatus -> print("${carStatus.id} ") }
    }
}
