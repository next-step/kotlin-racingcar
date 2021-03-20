package car.domain.history

class CarMoveHistoryCollection(
    private val moveHistories: List<CarMoveHistory>
) : List<CarMoveHistory> by moveHistories
