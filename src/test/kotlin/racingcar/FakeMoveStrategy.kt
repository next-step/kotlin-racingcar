package racingcar

import racingcar.model.Cars
import racingcar.strategy.MoveStrategy

class FakeMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean = true
}

class LastPlayerWinFakeMoveStrategy(private var cars: Cars) : MoveStrategy {
    private var count = 1
    override fun canMove(): Boolean {
        val carCount = cars.getNumberOfCars()
        val ret = (count % carCount == 0)
        count++
        return ret
    }
}
