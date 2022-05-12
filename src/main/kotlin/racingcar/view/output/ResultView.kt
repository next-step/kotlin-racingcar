package racingcar.view.output

import racingcar.model.RacingGame
import racingcar.model.RacingRecord

interface ResultView {
    fun showResultView(racingGame: RacingGame)
    fun showResultView(racingRecord: RacingRecord)
}
