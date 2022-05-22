package racing.domain

import racing.domain.vo.Position

class Cars(private val cars: List<Car>) {
    constructor(cars: Names) : this(cars.names.map { Car(it, Position()) })

    fun moveCars(): MoveResults {
        val moveResult = cars.map { it.move(RandomMoving) }
        return MoveResults(moveResult)
    }
}
