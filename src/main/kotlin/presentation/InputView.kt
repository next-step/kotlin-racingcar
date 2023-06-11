package presentation

class InputView {

    fun inputData(): Int = try {
        readln().toInt()
    } catch (e: NumberFormatException) {
        throw NumberFormatException("Cannot convert the character to an integer.")
    }
}
