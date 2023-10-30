package racingcar.domain

object CarRacingInputValidator {
    fun validateCount(input: Int): Int {
        require(input > 0) { "갯수는 0보다 커야 합니다" }
        return input
    }
}
