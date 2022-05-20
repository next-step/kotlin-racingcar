package step4

class Race(val cars: List<Car>, private val tries: Int, private val currentTries: Int = 1) {
    private val moveDecisionMaker = MoveDecisionMaker()

    fun isFinished(): Boolean = tries <= currentTries

    fun next(): Race {
        val nextCars = cars.map { if (moveDecisionMaker.canMove()) it.move() else it }
        return Race(nextCars, tries, currentTries + 1)
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
