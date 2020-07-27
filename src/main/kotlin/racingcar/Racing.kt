package racingcar

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

        for (i in 1..InputView.getChanceToMove()) {
            for (j in cars.indices) {
                cars[j].randomNum = (0..9).random()
                if (isRunnable(j))
                    cars[j].run()
            }
            ResultView.print(cars)
        }
    }

    fun isRunnable(i: Int) = cars[i].randomNum in 4..9
}
