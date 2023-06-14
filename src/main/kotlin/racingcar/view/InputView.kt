package racingcar.view

object InputView {
    private const val DELIMITER = ","

    fun inputName(): List<String> = readln().split(DELIMITER)
    fun inputNumber(): Int = readln().toInt()
}
