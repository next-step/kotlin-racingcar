package racingcar

import racingcar.domain.BulletinBoard
import racingcar.domain.Lap
import racingcar.domain.Names
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
        val names = Names.of(view.names())
        val laps = view.laps()
        var participants = RacingCars.of(names, RandomMovingStrategy())
        var board = BulletinBoard.EMPTY_BULLETIN_BOARD

        (1..laps).forEach {
            participants = controller.race(participants)
            board = controller.record(board, participants, Lap(it))
        }

        view.output(board)
    }
}
