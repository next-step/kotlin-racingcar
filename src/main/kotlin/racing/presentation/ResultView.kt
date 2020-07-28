package racing.presentation

import racing.domain.Cars
import racing.domain.Winner

class ResultView {
    fun view(list: List<Cars>) {

        list.forEach { result ->
            result.forEach { car -> println("${car.name} : ${car.distance}") }
            println()
        }
    }

    fun viewWinner(winners: List<Winner>) {
        val joinToString = winners.joinToString { winner -> winner.name }
        println(joinToString + "가 최종 우승했습니다.")
    }
}
