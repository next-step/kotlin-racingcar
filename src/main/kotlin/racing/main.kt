package racing

fun main() {
    val racingInputDto = InputView.input()

    val cars = Cars.of(racingInputDto.carCount, RandomNumberForwardCondition())
    val racing = Racing(cars, racingInputDto.attemptCount)
    val racingPhasedRecords = racing.start()

    OutputView.output(racingPhasedRecords)
}
