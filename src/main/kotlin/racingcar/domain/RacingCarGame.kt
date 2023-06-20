package racingcar.domain

import racingcar.controller.RacingCarController
import kotlin.random.Random

class RacingCarGame(
    val racingCars: List<RacingCar>,
) {
    fun racing() {
        racingCars.forEach {
            it.move()
        }
    }

    fun winners(): String {
        val maxPosition = maxPosition()
        return createWinners(maxPosition)
    }

    private fun maxPosition(): Int {
        return racingCars
            .maxOf { it.position }
    }

    private fun createWinners(maxPosition: Int): String =
        racingCars
            .filter { it.position == maxPosition }
            .joinToString { it.name }

    companion object {
        fun from(racingCarNames: String): RacingCarGame {
            val racingCars = racingCarNames
                .split(RacingCarController.CAR_NAME_SPLIT_SYMBOL)
                .map { RacingCar(it) { Random.nextInt(0, 10) } }
            return RacingCarGame(racingCars)
        }
    }
}
