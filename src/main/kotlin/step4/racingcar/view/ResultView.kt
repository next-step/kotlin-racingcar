package step4.racingcar.view

import step4.racingcar.domain.Car
import step4.racingcar.domain.GameResult

object ResultView {
    fun view(gameResult: GameResult) {
        println(">>>>> 실행결과")
        repeat(gameResult.round) { round ->
            printRacingPerRound(gameResult.cars, round)
        }
        gameResult.getWinners().also {
            println("[${it.joinToString()}]가 최종 우승했습니다.")
        }
    }

    private fun printRacingPerRound(carList: List<Car>, round: Int) {
        println(">>>>> 시도 횟수 : ${round.plus(1)}")
        for (car in carList) {
            carMove(car, round)
            println()
        }
        println(">>>>>> 끝")
    }

    private fun carMove(car: Car, round: Int) {
        for (i in 0..round) {
            printRacerNameOrPass(i, car.racerName)
            printMovementOrPass(i, car.movements)
        }
    }

    private fun printRacerNameOrPass(index: Int, racerName: String) {
        if (index == 0) {
            print("$racerName : ")
        }
    }

    private fun printMovementOrPass(index: Int, movements: List<Boolean>) {
        if (movements[index]) {
            print("-")
        }
    }
}
