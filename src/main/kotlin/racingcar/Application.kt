package racingcar

import racingcar.domain.Record
import racingcar.ui.RacingController
import racingcar.view.InputView

fun splitText(text: String, delimiter: String): List<String> {
    return try {
        text.split(delimiter)
    } catch (e: IllegalArgumentException) {
        emptyList()
    }
}

fun main() {
    val racingController = RacingController(InputView(), Record.EMPTY)
    racingController.start()
}
