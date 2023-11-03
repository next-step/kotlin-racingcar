package carRacing

import carRacing.domain.Racing
import carRacing.enum.Message
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.view.CarInfo
import carRacing.view.InputView
import carRacing.view.MessageGenerator

fun main() {
    val inputView = InputView()
    val messageGenerator: MessageGenerator = MessageGenerator()

    val carNameList: List<String> = inputView.readLineList(messageGenerator.getMessage(Message.CAR_NAME_QUESTION))
    val carInfoList = carNameList.map { CarInfo(it) }

    val tryCount: Int = inputView.readLineNumber(messageGenerator.getMessage(Message.TRY_COUNT_QUESTION))

    println()
    println(messageGenerator.getMessage(Message.RESULT))

    val racing = Racing(RandomMovementCarFactory())

    racing.getRaceResult(carInfoList, tryCount)
}
