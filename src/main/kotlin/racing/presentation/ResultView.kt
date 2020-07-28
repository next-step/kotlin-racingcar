package racing.presentation

import racing.domain.Cars

class ResultView {
    fun view(list: List<Cars>) {

        list.forEach { result ->
            result.forEach { car -> println("${car.name} : ${car.distance}") }
            println()
        }
    }
}
