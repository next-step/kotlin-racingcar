package racingCar2

class InputIO {
    fun inputCarNames(inputString: String? = readlnOrNull()): List<String> {
        requireNotNull(inputString) { "자동차 이름을 입력해 주세요" }
        return inputString.split(",")
    }

    fun inputGameCount(inputNumber: Int? = readlnOrNull()?.toInt()): Int {
        requireNotNull(inputNumber) { "시도할 횟수를 입력해 주세요." }
        check(inputNumber > 0) { "시도할 횟수는 양수만 입력해 주세요." }

        return inputNumber
    }
}
