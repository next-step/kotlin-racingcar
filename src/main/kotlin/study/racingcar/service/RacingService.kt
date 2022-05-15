package study.racingcar.service

import study.racingcar.domain.Moving
import study.racingcar.domain.Racing

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
