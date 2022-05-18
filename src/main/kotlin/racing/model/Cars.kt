package racing.model

import racing.RandomMoving

class Cars(private val cars: List<Car>) {
    fun moveCars(): MoveResults {
        val moveResult = cars.map { it.move(RandomMoving) }
        return MoveResults(moveResult)
    }
}
