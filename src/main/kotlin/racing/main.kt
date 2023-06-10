package racing

fun main() {
    val racingInputDto = InputView.read()

    val cars = Cars.of(racingInputDto.carCount, RandomNumberForwardCondition())
    val racing = Racing(cars, racingInputDto.attemptCount)
    val racingPhasedRecords = racing.start()

    OutputView.print(racingPhasedRecords)
}
