package step3.domain

class GameResult(
    private val initialPositions: CarPositions,
    positionsResult: MutableList<CarPositions> = mutableListOf()
) {
    private val positionsResult: MutableList<CarPositions>

    init {
        this.positionsResult = positionsResult.toMutableList()
    }

    fun getLastPositions(): CarPositions {
        if (positionsResult.isEmpty()) {
            return initialPositions
        }
        return positionsResult.last()
    }

    fun getPositionsResult(): List<CarPositions> {
        return positionsResult.toList()
    }

    fun add(cars: CarPositions) {
        this.positionsResult.add(cars)
    }

    companion object {
        fun of(carPositions: CarPositions): GameResult {
            return GameResult(initialPositions = carPositions)
        }
    }
}
