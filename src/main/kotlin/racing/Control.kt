package racing

import racing.model.Racing
import racing.view.InputView
import racing.view.OutputView

fun main() {
    val racing = Racing()
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printResults(
        racing.race(
            inputView.participate(),
            inputView.repeat()
        )
    )
}
