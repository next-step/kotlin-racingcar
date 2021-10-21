package racingcar

import racingcar.domain.Lap
import racingcar.domain.RacingCars
import racingcar.domain.RacingController
import racingcar.domain.strategy.RandomMovingStrategy
import racingcar.ui.RacingCarView

fun main() {
    RacingCarApplication(
        RacingCarView(),
        RacingController()
    ).run()
}

class RacingCarApplication(
    private val view: RacingCarView,
    private val controller: RacingController
) {
    fun run() {
        val cars = view.cars()
        val laps = view.laps()
        var participants = RacingCars.of(cars, RandomMovingStrategy())

        (1..laps).forEach { participants = controller.race(participants, Lap(it)) }

        view.output(laps, controller.board)
    }
}
