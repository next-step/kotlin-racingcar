package car.domain.history

class CarMoveHistories(
    private val moveHistories: List<CarMoveHistory>
) : List<CarMoveHistory> by moveHistories
