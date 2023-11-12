package carRacing.view

import carRacing.domain.Car
import carRacing.domain.CarList
import carRacing.enum.Message

class OutputView {

    private val messageGenerator: MessageGenerator = MessageGenerator()

    fun printCarNameAndPosition(carList: CarList) {
        for (car in carList.getCarList()) {
            printCarNameAndPosition(car)
        }

        println()
    }

    private fun printCarNameAndPosition(car: Car) {
        println("${car.name} : ${getPositionDash(car)}")
    }

    private fun getPositionDash(car: Car): String = "-".repeat(car.position)

    fun printWithMessage(message: Message, vararg messages: String) {
        println(messageGenerator.getMessage(message, *messages))
    }
}
