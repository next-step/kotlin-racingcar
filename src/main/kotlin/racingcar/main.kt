package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    InputView
        .run()
        .apply(ResultView::run)
}
