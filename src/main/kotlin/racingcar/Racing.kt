package racingcar

object Racing {

    fun start() {
        val cars = RacingCarFactory.makeCars(InputView.getCarNumber())
        val trials = InputView.getChanceToMove()

        println("\n실행 결과")

        for (i in 1..trials) {
            for (x in cars.indices) {
                cars[x].run((0..9).random())
            }
            ResultView.print(cars)
        }
    }
}
