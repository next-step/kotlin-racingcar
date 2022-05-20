package step3

class Race private constructor(val cars: List<Car>, private val tries: Int, private val currentTries: Int = 1) {
    private val moveDecisionMaker = MoveDecisionMaker()

    constructor(numCars: Int, tries: Int, currentTries: Int = 1) : this(
        (1..numCars).map { Car.create() }, tries, currentTries
    )

    fun isFinished(): Boolean = tries <= currentTries

    fun next(): Race {
        val nextCars = cars.map { if (moveDecisionMaker.canMove()) it.move() else it }
        return Race(nextCars, tries, currentTries + 1)
    }
}
