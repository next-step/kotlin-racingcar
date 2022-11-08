package step3.view.result.impl

import step3.view.result.RacingGameHistoryView
import step3.view.result.ResultView
import step3.view.result.WinnerRacingCarListView

abstract class AbstractResultView(

    private val racingGameHistoryView: RacingGameHistoryView = DefaultRacingGameHistoryView(),

    private val winnerRacingCarList: WinnerRacingCarListView = DefaultWinnerRacingCarListView()
) : ResultView, RacingGameHistoryView by racingGameHistoryView, WinnerRacingCarListView by winnerRacingCarList
