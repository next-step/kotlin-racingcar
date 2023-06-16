package racingcar.view

import racingcar.domain.car.Car
import racingcar.domain.racing.RacingGame

object ResultView {

    private fun outputLapResult(cars: List<Car>) {
        cars.forEach { car ->
            print("${car.name}: ")
            println("-".repeat(car.position))
        }
        println()
    }

    fun outputResult(racingGame: RacingGame) {
        val tryCount = racingGame.racingCondition.tryCount
        val cars = racingGame.carList.cars

        println("실행 결과")
        (0 until tryCount).forEach { lap ->
            outputLapResult(cars)
        }
        outputWinner(racingGame)
    }

    private fun outputWinner(racingGame: RacingGame) {
        println("${racingGame.getWinner()}가 최종 우승했습니다.")
    }
}
