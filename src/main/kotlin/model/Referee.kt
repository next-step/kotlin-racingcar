package model

class Referee(private val racingCars: RacingCars) {
    fun judge(): List<String> {
        val max = getMaxMovement()
        return getMaxMovedRacingCarNames(max)
    }

    private fun getMaxMovement(): Int {
        return racingCars.racingCars.maxOf { it.getMoved() }
    }

    private fun getMaxMovedRacingCarNames(max: Int): List<String> {
        return racingCars.racingCars
            .filter { it.getMoved()== max }
            .map { it.name }
    }
}
