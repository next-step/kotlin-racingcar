package study.step3.resultview

import study.step3.Car

class StdoutResultView : ResultView {

    override fun printResult(cars: List<Car>) {
        cars.forEach {
            println(it.getMovementTrace())
        }
        println()
    }
}
