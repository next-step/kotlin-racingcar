package carracinggame.feature

import carracinggame.core.domain.DetermineCarMovementUseCase
import carracinggame.core.model.Car
import carracinggame.core.model.findWinners
import carracinggame.core.util.StringParser

class CarRacingGameController(
    private val determineCarMovementUseCase: DetermineCarMovementUseCase = DetermineCarMovementUseCase(),
) {
    var cars: List<Car> = emptyList()
        private set
    var attemptCount: Int = 0
        private set

    fun initializeGameState(
        carNamesInput: String,
        attemptCountInput: String,
    ) {
        val carNames = StringParser.splitByComma(carNamesInput)
        val attemptCounts = StringParser.convertToInt(attemptCountInput)

        cars = carNames.map { Car(name = it) }
        attemptCount = attemptCounts
    }

    fun updateCarDistance() {
        cars.forEach { it.updateCurrentDistance(determineCarMovementUseCase) }
    }

    fun formatWinnerNames(): String = StringParser.combineByComma(cars.findWinners().map { it.name })
}
