package racingcar.view

class InputView {
    fun getCarNumber(): Int? {
        println(MESSAGE_CAR_NUMBER)
        return readln().toIntOrNull()
    }

    companion object {
        private const val MESSAGE_CAR_NUMBER = "How many cars are in the race?"
    }
}
