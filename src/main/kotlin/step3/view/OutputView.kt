package step3.view

import step3.CarName
import step3.CurrentCarStatus

interface OutputView {
    fun showResultTitle()
    fun showStatus(carStatuses: List<CurrentCarStatus>)
    fun showWinner(winnerNames: List<CarName>)
}
