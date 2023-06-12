package step3.racingcar.service

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.Round
import step3.racingcar.domain.condition.Condition
import step3.racingcar.view.OutputView

class RacingGameService {

    private val defaultPosition = 0
    private lateinit var cars: Cars
    private lateinit var round: Round

    fun initCars(count: Int, condition: Condition) {
        cars = Cars(List(count) { Car(defaultPosition, condition) })
    }

    fun initRound(attemptCount: Int) {
        round = Round(attemptCount)
    }

    fun play() {
        repeat(round.attemptCount) {
            cars.move()
            cars.getPosition()
            OutputView.print()
        }
    }
}
