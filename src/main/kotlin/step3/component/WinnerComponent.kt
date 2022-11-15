package step3.component

import step3.Car
import step3.WinnerCalculator
import step3.ui.Span

class WinnerComponent(private val cars: List<Car>) : Component {
    private fun getWinnerText(winners: List<Car>): String {
        return winners.joinToString(", ") { it.name }
    }

    override fun render() {
        val winners = WinnerCalculator.execute(cars = cars)
        val text = "${this.getWinnerText(winners)} 가 최종 우승했습니다."
        Span(text = text).draw()
    }
}
