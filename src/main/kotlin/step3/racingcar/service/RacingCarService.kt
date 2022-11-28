package step3.racingcar.service

import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.view.ResultView.Companion.printRoundResult
import step3.racingcar.view.ResultView.Companion.printWinner

class RacingCarService {
    fun play(playInfo: PlayInfo) {
        repeat(playInfo.totalRound) {
            playEachRound(it, playInfo.cars)
        }
        printWinner(playInfo.cars)
    }

    private fun playEachRound(currentRoundIndex: Int, cars: Cars) {
        cars.elements().forEach {
            it.race(currentRoundIndex)
        }
        printRoundResult(currentRoundIndex, cars)
    }
}
