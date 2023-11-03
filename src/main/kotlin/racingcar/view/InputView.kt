package racingcar.view

object InputView {
    fun inputNumber(): Int {
        return readln().validateInputNumber().toInt()
    }
}
