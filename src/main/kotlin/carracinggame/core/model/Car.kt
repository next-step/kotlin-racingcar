package carracinggame.core.model

import carracinggame.core.domain.DetermineCarMovementUseCase

class Car(val name: String) {
    var totalDistance: Int = 0
        private set

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다" }
    }

    fun updateCurrentDistance(determineCarMovementUseCase: DetermineCarMovementUseCase) {
        if (determineCarMovementUseCase()) {
            totalDistance++
        }
    }
}

fun List<Car>.findWinners(): List<Car> {
    val maxDistance = this.maxOf { it.totalDistance }
    return this.filter { it.totalDistance == maxDistance }
}
