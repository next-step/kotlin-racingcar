package car.domain

import car.domain.history.CarMoveHistories
import car.domain.winner.Winners

data class Game(private val cars: Cars) {
    private val _allCarMoveHistories: MutableList<CarMoveHistories> = mutableListOf()
    val allCarMoveHistories: List<CarMoveHistories>
        get() = _allCarMoveHistories

    val winners: Winners
        get() = Winners(cars.currentMoveHistories)

    fun move(times: Int) {
        repeat(times) {
            cars.move()
            _allCarMoveHistories.add(cars.currentMoveHistories)
        }
    }
}
