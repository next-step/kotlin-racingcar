package racing

import racing.domain.Racing
import racing.ui.InputView
import racing.ui.OutputView

fun main() {
    val racingInputDto = InputView.read()

    val racing = Racing.of(racingInputDto.carNames)
    val racingPhasedRecords = racing.start(racingInputDto.attemptCount)

    OutputView.print(racingPhasedRecords)
}
