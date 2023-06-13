package racing

import racing.domain.Cars
import racing.domain.Racing
import racing.domain.RandomNumberForwardCondition
import racing.ui.InputView
import racing.ui.OutputView

fun main() {
    val racingInputDto = InputView.read()

    val cars = Cars.of(racingInputDto.carNames, RandomNumberForwardCondition())
    val racing = Racing(cars, racingInputDto.attemptCount)
    val racingPhasedRecords = racing.start()

    OutputView.print(racingPhasedRecords)
}
