package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView
import racingcar.ui.WinnerView

fun main() {
    InputView
        .run()
        .run(ResultView::run)
        .run(WinnerView::run)
}
