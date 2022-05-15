package study.step3.service

import study.step3.domain.Moving
import study.step3.domain.Racing

class RacingService(private val numOfCar: Int, private val numOfTry: Int) {
    fun start() {
        val racing = Racing(numOfCar, Moving())

        println("실행결과")

        repeat((1..numOfTry).count()) {
            racing.race()
            println()
        }
    }
}
