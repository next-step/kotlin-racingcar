package carRacing

import carRacing.domain.Car
import carRacing.domain.Racing
import carRacing.domain.RacingResult
import carRacing.enum.Message
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.view.InputView
import carRacing.view.MessageGenerator
import carRacing.view.OutputView

fun main() {
    val messageGenerator: MessageGenerator = MessageGenerator()

    val inputView = InputView()
    val carNameList: List<String> = inputView.readLineList(messageGenerator.getMessage(Message.CAR_NAME_QUESTION))
    val tryCount: Int = inputView.readLineNumber(messageGenerator.getMessage(Message.TRY_COUNT_QUESTION))

    println()
    println(messageGenerator.getMessage(Message.RESULT))

    val carList: List<Car> = RandomMovementCarFactory().createCarList(carNameList)

    val racing = Racing(carList)
    val racingResult: RacingResult = racing.getRaceResult(tryCount)

    val outputView: OutputView = OutputView()
    racingResult.getRacingResultHistory().forEach(outputView::printCarNameAndPosition)

    println(messageGenerator.getMessage(Message.WINNER, racingResult.getWinnerNames().joinToString(", ")))
}
