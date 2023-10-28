package racing

import racing.model.Racing
import racing.view.InputView
import racing.view.OutputView

fun main() {
    val racing = Racing()
    val inputView = InputView()
    val outputView = OutputView()

    val participate = inputView.participate()
    val repeat = inputView.repeat()
    val matchResults = racing.race(participate, repeat)
    outputView.printResults(matchResults)
}
