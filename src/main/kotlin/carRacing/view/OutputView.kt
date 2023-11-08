package carRacing.view

import carRacing.domain.Car
import carRacing.enum.Message

class OutputView {

    private val messageGenerator: MessageGenerator = MessageGenerator()

    fun printMessageInBox(message: String) {
        println("====================================")
        println(message)
        println("====================================")
    }

    fun printMessagesInBox(vararg messages: String) {
        println("====================================")
        printMessages(*messages)
        println("====================================")
    }

    fun printMessages(vararg messages: String) {
        for (message in messages) {
            println(message)
        }

        println()
    }

    fun printCarNameAndPosition(carList: List<Car>) {
        for (car in carList) {
            printCarNameAndPosition(car)
        }

        println()
    }

    private fun printCarNameAndPosition(car: Car) {
        println("${car.name} : ${car.getPosition()}")
    }

    fun printWithMessage(message: Message, vararg messages: String) {
        println(messageGenerator.getMessage(message, *messages))
    }
}
