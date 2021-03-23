package car.domain.history

class CarMoveHistories(
    private val moveHistories: List<CarMoveHistory> = listOf()
) : List<CarMoveHistory> by moveHistories {
    fun add(carMoveHistory: CarMoveHistory) = CarMoveHistories(moveHistories + carMoveHistory)
}
