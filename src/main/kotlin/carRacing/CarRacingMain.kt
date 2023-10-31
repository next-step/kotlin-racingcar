package carRacing

import carRacing.domain.MessageGenerator
import carRacing.enum.Message
import carRacing.view.InputView

fun main() {
    val inputView = InputView()
    val messageGenerator: MessageGenerator = MessageGenerator()

    val carCount: Int = inputView.readLineNumber(messageGenerator.getMessage(Message.CAR_COUNT_QUESTION))

    val tryCount: Int = inputView.readLineNumber(messageGenerator.getMessage(Message.TRY_COUNT_QUESTION))

    println()
    println(messageGenerator.getMessage(Message.RESULT))
}
