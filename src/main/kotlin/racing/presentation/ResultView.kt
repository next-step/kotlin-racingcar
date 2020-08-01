package racing.presentation

import racing.domain.Cars

class ResultView {

    companion object {
        const val CHARACTER = "-"
    }

    fun show(list: List<Cars>) {
        list.forEach { result ->
            result.forEach { car -> println("${car.name} " + CHARACTER.repeat(car.distance)) }
            println()
        }
    }

    fun showWinner(winners: Cars) {
        val joinToString = winners.joinToString { winner -> winner.name }
        println(joinToString + "가 최종 우승했습니다.")
    }
}
