package racingcar.tasks

import racingcar.model.Car
import racingcar.util.Message.Companion.NOTICE_NOT_NULL_WINNER

class WinnersReader(private val cars: List<Car>) {
    fun findWinners(): List<Car> {
        return cars.filter { it.getPosition() == getMaxPosition() }
    }

    private fun getMaxPosition(): Int {
        return requireNotNull(
            cars.map { it.getPosition() }
                .max()
        ) { NOTICE_NOT_NULL_WINNER }
    }
}
