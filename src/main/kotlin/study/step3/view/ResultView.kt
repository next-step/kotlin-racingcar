package study.step3.view

import study.step3.model.Car

class ResultView {

    companion object {
        fun result(cars: List<Car>, racingTimes: Int) {
            println("실행 결과")
            (1..racingTimes).forEach { times ->
                cars.forEach {
                    val i = it.history()[times]
                    requireNotNull(i)
                    println("-".repeat(i))
                }
                println()
            }
        }
    }
}
