package racingCarWinner.domain

data class UserInput(
    val carNames: List<String>,
    val numOfAttempts: Int,
) {
    init {
        require(carNames.map { it.trim().length }.all { it in 1..5 }) {
            "자동차 이름은 1~5자만 가능합니다."
        }
        require(numOfAttempts > 0) {
            "시도 횟수는 1 이상만 가능합니다."
        }
    }

    companion object {
        fun of(carNames: String, numOfAttempts: String): UserInput {
            require(numOfAttempts.toIntOrNull() != null) {
                "시도 횟수는 숫자여야 합니다."
            }
            return UserInput(
                carNames = carNames.split(","),
                numOfAttempts = numOfAttempts.toInt()
            )
        }
    }
}