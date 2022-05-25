package study.racingcar.service

import study.racingcar.domain.Racing
import study.racingcar.view.RacingView

class RacingService {

    fun race(racing: Racing) {
        repeat((1..racing.totalRound).count()) {
            racing.start()
            RacingView(racing).printRacing()
        }
    }
}
