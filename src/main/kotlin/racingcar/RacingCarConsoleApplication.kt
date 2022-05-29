package racingcar

import racingcar.domain.RaceHost
import racingcar.view.RacingCarInputView
import racingcar.view.RacingCarOutputView
import racingcar.view.RacingCarRequest

fun main() {
    val racingCarRequest: RacingCarRequest = RacingCarInputView.input()
    val racingResults = RaceHost.play(
        racingCarRequest.rounds,
        carNames = racingCarRequest.carNames,
    )
    RacingCarOutputView.output(racingResults)
}
