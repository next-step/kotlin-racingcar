package racingcar.domain

import racingcar.controller.RacingCarController

class RacingCarGame(
    val racingCars: List<RacingCar>,
) {
    fun racing(generator: NumberGenerator) {
        racingCars.forEach {
            it.move(generator.generateNumber())
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
            val racingCars = mutableListOf<RacingCar>()
            val carNameSplit = racingCarNames.split(RacingCarController.CAR_NAME_SPLIT_SYMBOL)
            carNameSplit.mapTo(racingCars) { RacingCar(it) }
            return RacingCarGame(racingCars)
        }
    }
}
