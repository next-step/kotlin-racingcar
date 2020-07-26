package racingcar

import kotlin.random.Random

object Racing {
    private val input = InputView
    private val racingCarFactory = RacingCarFactory
    val cars = racingCarFactory.cars

    private fun takeInputs() {
        input.setCarNumsAndChanceToMove()
    }

    private fun makeCars() {
        for (i in 1..input.number) {
            racingCarFactory.makeCar()
        }
    }

    fun start() {
        takeInputs()
        makeCars()

        println("\n실행 결과")

        // TODO 이중 반복문 수정하기?
        for (i in 1..input.chanceToMove) {
            for (j in cars.indices) {
                cars[j].randomNum = Random.nextInt(10)
                if (isRunnable(j))
                    cars[j].run()
            }
            ResultView.print(cars)
        }
    }

    fun isRunnable(i: Int) = cars[i].randomNum in 4..9
}
