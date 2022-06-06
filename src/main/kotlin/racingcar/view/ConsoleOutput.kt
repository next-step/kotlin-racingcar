package racingcar.view

import racingcar.domain.result.CarRaceResult
import racingcar.domain.result.CarRaceResultForRound
import racingcar.domain.result.CarSnapShot

private const val CONSOLE_CAR_POSITION_EXPRESSION = "-"
private const val INDEX_ROUND_DIFFERENCE = 1
private const val WINNER_NAME_SEPARATOR = ","

class ConsoleOutput : OutputView {
    override fun printCarRace(carRaceResult: CarRaceResult) {
        println("실행 결과")
        carRaceResult.carRaceResults.forEachIndexed { idx, result -> printCarRaceForOneRound(idx, result) }
        val winners = carRaceResult.findWinners()
        println("${winners.joinToString(WINNER_NAME_SEPARATOR) { it.name }}(이)가 최종 우승했습니다.")
    }

    private fun printCarRaceForOneRound(round: Int, carRaceResultForRound: CarRaceResultForRound) {
        println("제 ${round + INDEX_ROUND_DIFFERENCE}회 결과")
        carRaceResultForRound.carSnapShots.forEach { printCarSnapShot(it) }
        println()
    }

    private fun printCarSnapShot(carSnapShot: CarSnapShot) {
        println("${carSnapShot.name} : ${carSnapShot.position.toStringForPrint()}")
    }
}

private fun Int.toStringForPrint(): String {
    return CONSOLE_CAR_POSITION_EXPRESSION.repeat(this)
}
