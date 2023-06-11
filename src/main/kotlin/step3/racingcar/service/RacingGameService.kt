package step3.racingcar.service

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.condition.Condition
import step3.racingcar.view.Messages
import step3.racingcar.view.OutputView

class RacingGameService {

    private val defaultPosition = 0
    private var attemptCount = 0
    private lateinit var cars: Cars

    fun initCars(count: Int, condition: Condition) {
        cars = Cars(List(count) { Car(defaultPosition, condition) })
    }

    fun initAttemptCount(count: Int) {
        validateAttemptCount(count)
        attemptCount = count
    }

    private fun validateAttemptCount(count: Int) {
        if (count < 1) {
            throw IllegalArgumentException(Messages.MESSAGE_CONDITION_ATTEMPT_COUNT)
        }
    }

    fun play() {
        repeat(attemptCount) {
            cars.move()
            cars.getPosition()
            OutputView.print()
        }
    }
}
