package racingcar.view

object InputView {

    private const val NAME_DELIMITER = ','
    fun inputNames(): List<String> {
        return readln().validateBlank().split(NAME_DELIMITER)
    }

    fun inputNumber(): Int {
        return readln().validateInputNumber().toInt()
    }
}
