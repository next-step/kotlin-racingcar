package carRacing

import carRacing.domain.Car
import carRacing.domain.Racing
import carRacing.enum.Message
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.view.CarInfo
import carRacing.view.InputView
import carRacing.view.MessageGenerator

fun main() {
    val messageGenerator: MessageGenerator = MessageGenerator()

    val inputView = InputView()
    val carNameList: List<String> = inputView.readLineList(messageGenerator.getMessage(Message.CAR_NAME_QUESTION))
    val tryCount: Int = inputView.readLineNumber(messageGenerator.getMessage(Message.TRY_COUNT_QUESTION))

    println()
    println(messageGenerator.getMessage(Message.RESULT))

    val racing = Racing(RandomMovementCarFactory())
    val carInfoList = carNameList.map { CarInfo(it) }
    val racingResult: List<Car> = racing.getRaceResult(carInfoList, tryCount)
    val winnerNameList: List<String> = racing.getWinnerNames(racingResult)

    println()
    println(messageGenerator.getMessage(Message.WINNER, winnerNameList.joinToString(", ")))
}
