package racinggame.view

import racinggame.view.converter.InputConverter
import racinggame.view.validator.InputValidator

class InputView<T>(
    private val inputMessage: String,
    private val inputConverter: InputConverter<T>,
    private val validator: InputValidator<T>
) {
    fun receive(): T {
        printInputMessage()
        return receiveUserInput()
    }

    private fun printInputMessage() {
        println(inputMessage)
    }

    private fun receiveUserInput() = validator.validate(
        inputConverter.convert(readln())
    )
}
