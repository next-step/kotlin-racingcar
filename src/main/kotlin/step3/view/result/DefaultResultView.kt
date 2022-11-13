package step3.view.result

import step3.domain.game.RacingGame
import step3.view.result.history.DefaultRacingGameHistoryView
import step3.view.result.history.RacingGameHistoryView

class DefaultResultView(
    private val racingGameHistoryView: RacingGameHistoryView = DefaultRacingGameHistoryView(),
) : ResultView, RacingGameHistoryView by racingGameHistoryView {

    override fun printRacingGameResult(racingGame: RacingGame) {
        check(racingGame.isCompleted()) { "RacingGame is not completed" }

        println("실행 결과")

        racingGame.historyList.forEach {
            printRacingGameHistory(it)
        }
    }
}
