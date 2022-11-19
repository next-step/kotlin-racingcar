package step3.racingcar.service

import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.utils.RandomNumberGenerator
import step3.racingcar.view.ResultView

class RacingCarService {
    fun play(playInfo: PlayInfo) {
        repeat(playInfo.totalRound) {
            playEachRound(it, playInfo.cars)
        }
    }

    private fun playEachRound(currentRound: Int, cars: Cars) {
        cars.elements().forEach {
            val randomValue = RandomNumberGenerator.generate()
            it.race(randomValue)
        }
        ResultView.printRoundResult(currentRound, cars)
    }
}
