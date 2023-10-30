package racingcar.domain

data class UserInput(
    val numOfCars: Int,
    val numOfAttempts: Int
) {
    init {
        require(numOfCars >= 0) {"자동차 대수는 0 이상의 숫자여야 합니다. (입력된 값: $numOfCars)"}
        require(numOfAttempts >= 0) {"게임 횟수는 0 이상의 숫자여야 합니다. (입력된 값: $numOfAttempts)"}
    }
}