package step3.domain

class GameResult(private val initialPositions: CarPositions, private val result: MutableList<CarPositions>) {
    fun getLastPositions(): CarPositions {
        if (result.isEmpty()) {
            return initialPositions
        }
        return result.last()
    }

    fun getResult(): List<CarPositions> {
        return result.toList()
    }

    fun add(cars: CarPositions) {
        this.result.add(cars)
    }

    companion object {
        fun of(carPositions: CarPositions): GameResult {
            return GameResult(initialPositions = carPositions, result = mutableListOf())
        }
    }
}
