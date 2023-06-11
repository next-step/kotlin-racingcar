package racingcar.domain

import racingcar.util.NumberGenerator

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
}
