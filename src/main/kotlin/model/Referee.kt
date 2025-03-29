package model

class Referee(private val racingCars: RacingCars) {
    fun judge(): List<String> {
        val max = getMaxMovement()
        return getMaxMovedRacingCarNames(max)
    }

    private fun getMaxMovement(): Int {
        return racingCars.getRacingCars().maxOf { it.moved }
    }

    private fun getMaxMovedRacingCarNames(max: Int): List<String> {
        return racingCars.getRacingCars()
            .filter { it.moved== max }
            .map { it.name }
    }
}
