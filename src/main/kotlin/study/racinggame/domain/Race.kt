package study.racinggame.domain

import study.racinggame.presentation.dto.CarResponse

class Race(
    private val carStorage: List<Car>,
    private val raceRule: RaceRule = RaceRule()
) {

    fun runTrack(): List<CarResponse> {
        moveCarsIfPossible()
        return carStorage.map(CarResponse::of)
    }

    fun getRaceWinner(): String {
        val maxValue: Int = carStorage.maxOf(Car::position)
        return carStorage.filter { it.position == maxValue }
            .joinToString(WINNER_SEPARATOR, transform = Car::name)
    }

    fun carStorage() = carStorage

    private fun moveCarsIfPossible() {
        for (car in carStorage) {
            car.move(raceRule.canMove())
        }
    }

    companion object {
        private const val WINNER_SEPARATOR: String = ", "
    }
}
