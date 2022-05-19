package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.MoveStrategy

class Racing(private val cars: Cars) {

    private val _racing = mutableListOf<Cars>()

    val history: List<Cars>
        get() = _racing

    val result: List<Car>
        get() = _racing.last().cars

    fun start(roundCount: Int, moveStrategy: MoveStrategy) {

        repeat(roundCount) {
            val racingCars = if (_racing.isNotEmpty()) _racing.last() else cars
            _racing.add(racingCars.move(moveStrategy))
        }
    }
}
