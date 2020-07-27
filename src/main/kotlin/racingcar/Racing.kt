package racingcar

import kotlin.random.Random

object Racing {
    private val racingCarFactory = RacingCarFactory
    val cars = racingCarFactory.cars

    private fun makeCars() {
        for (i in 1..InputView.getCarNumber()) {
            racingCarFactory.makeCar()
        }
    }

    fun start() {
        makeCars()

        println("\n실행 결과")

        // TODO 이중 반복문 수정하기?
        for (i in 1..InputView.getChanceToMove()) {
            for (j in cars.indices) {
                // TODO 03. (0..9).random() 사용
                cars[j].randomNum = Random.nextInt(10)
                if (isRunnable(j))
                    cars[j].run()
            }
            ResultView.print(cars)
        }
    }

    fun isRunnable(i: Int) = cars[i].randomNum in 4..9
}
