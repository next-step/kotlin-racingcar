package racingcar

import racingcar.car.Runnable
import racingcar.view.InputView
import racingcar.view.ResultView

class Racing<T: Runnable>(private val racingCarFactory: () -> T) {
    fun race() {
        val carCount = InputView.getCarCount()
        val racingCount = InputView.getRacingCount()

        doRacing(carCount, racingCount)
    }

    fun doRacing(carCount: Int, racingCount: Int) {
        val racingCars = getRacingCars(carCount)
        val doRacingEachRound = racingEachRound(racingCount)

        doRacingEachRound(racingCars, 0)
    }

    private fun getRacingCars(carCount: Int): List<T> {
        return Array(carCount) {it + 1}.map { racingCarFactory() }
    }

    private fun racingEachRound(totalRound: Int): (List<Runnable>, Int) -> Unit {
        return { cars, round ->
            if (round == totalRound) {
                // over the recursion
            } else {
                val nextCars = cars.map { it.run() }
                ResultView.printPositions(nextCars.map { it.position })
                racingEachRound(totalRound)(nextCars, round + 1)
            }
        }
    }
}
