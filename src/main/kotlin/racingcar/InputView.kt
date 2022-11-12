package racingcar

class InputView {
    fun inputInt(): Int {
        return readln().toInt()
    }

    fun inputCarNames(): List<String> {
        val input = readln()
        val carNames = input.trim().split(",")

        for (carName in carNames) {
            if (carName.length > NAME_LENGTH_CONDITION)
                throw IllegalArgumentException("자동자 이름은 ${NAME_LENGTH_CONDITION}자를 넘을 수 없습니다.")
        }

        return carNames
    }

    companion object {
        const val NAME_LENGTH_CONDITION = 5
    }
}
