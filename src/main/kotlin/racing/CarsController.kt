package racing

object CarsController {

    fun play() {
        val names = CarName.from(InputView.getCarsName())
        val cars = CarsFactory.create(names)
        val round = Round(InputView.getRound())

        OutputView.printStartResult()
        repeat(round.value) {
            cars.goAll()
            OutputView.printResult(CarsDto(cars))
        }
        OutputView.printWinner(CarsDto(cars.getWinner()))
    }
}
