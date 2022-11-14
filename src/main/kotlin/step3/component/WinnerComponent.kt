package step3.component

import step3.Car
import step3.ui.Span

class WinnerComponent(private val cars: List<Car>) : Component {

    private fun calculateWinners(cars: List<Car>): List<String> {
        val winnerCars = cars
            .groupBy { it.position.value }
            .maxByOrNull { it.key }
            ?.value ?: throw IllegalStateException("우승자를 구할 수 없습니다.")

        return winnerCars.map { it.name }
    }

    private fun getWinnerText(winners: List<String>): String {
        return winners.joinToString(", ")
    }

    override fun render() {
        val winners = this.calculateWinners(cars = cars)
        Span(text = "${getWinnerText(winners)} 가 최종 우승했습니다.").draw()
    }
}
