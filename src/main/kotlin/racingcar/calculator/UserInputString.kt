package racingcar.calculator

class UserInputString(val userInput: String) {
    fun getUserInputString(): String {
        if (userInput.isEmpty()) throw IllegalArgumentException("입력이 빈 문자열입니다")
        return userInput
    }
}
