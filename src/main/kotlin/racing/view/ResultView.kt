package racing.view

import racing.domain.CarRacing

object ResultView {

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printResult(carRacing: CarRacing) {
        carRacing.positions.forEach { println("-".repeat(it)) }
        println()
    }
}
