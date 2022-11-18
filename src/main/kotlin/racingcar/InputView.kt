package racingcar

class InputView {
    fun inputInt(): Int {
        return readln().toInt()
    }

    fun inputCarNames(): List<String> {
        val input = readln()
        return input.trim().split(",")
    }
}
