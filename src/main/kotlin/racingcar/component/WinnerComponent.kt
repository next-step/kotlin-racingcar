package racingcar.component

import racingcar.Winner
import racingcar.ui.Span

class WinnerComponent(private val winners: List<Winner>) : Component {
    private fun getWinnerText(winners: List<Winner>): String {
        return winners.joinToString(", ") { it.name.value }
    }

    override fun render() {
        val text = "${this.getWinnerText(winners)} 가 최종 우승했습니다."
        Span(text = text).draw()
    }
}
