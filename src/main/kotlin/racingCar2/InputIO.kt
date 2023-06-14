package racingCar2

class InputIO {
    fun inputCarNames(inputString: String? = readlnOrNull()): List<String> {
        requireNotNull(inputString) { "자동차 이름을 입력해 주세요" }
        return inputString.split(",")
    }
}
