package racing

@JvmInline
value class Round(val value: Int) {
    init {
        require(value > 0) { "라운드는 양의 정수입니다." }
    }
}

object CarsController {

    fun createCars(): Cars {
        val count = CarCount(InputView.getCarCount())
        return CarsFactory.create(count)
    }

    fun play(cars: Cars) {
        val round = Round(InputView.getRound())

        OutputView.printStartResult()
        repeat(round.value) {
            cars.goAll()
            OutputView.printResult(cars)
        }
    }
}
