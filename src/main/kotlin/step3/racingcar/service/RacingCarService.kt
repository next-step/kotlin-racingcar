package step3.racingcar.service

import step3.racingcar.domain.Cars
import step3.racingcar.utils.CarGenerator
import step3.racingcar.utils.RandomNumberGenerator
import step3.racingcar.view.ResultView

class RacingCarService {
    fun play(carCount: Int, roundCount: Int) {
        val cars: Cars = CarGenerator.generate(carCount)

        for (i in 1..roundCount step 1) {
            playEachRound(i, cars)
        }
    }

    private fun playEachRound(currentRound: Int, cars: Cars) {
        ResultView.roundResultGuideMessage(currentRound)
        cars.elements.forEach {
            val randomValue = RandomNumberGenerator.generate()
            it.race(randomValue)
            ResultView.printEachCarScore(it)
        }
    }
}
