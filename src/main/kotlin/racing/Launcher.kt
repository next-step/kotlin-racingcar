package racing

import racing.model.MatchResult
import racing.model.Racing
import racing.view.InputView
import racing.view.OutputView

class Launcher

fun main() {
    val racing = Racing()
    val inputView = InputView()
    val outputView = OutputView()

    val participate: Int = inputView.participate()
    val repeat: Int = inputView.repeat()
    val results: List<MatchResult> = racing.race(participate, repeat)
    outputView.printResults(results)
}
