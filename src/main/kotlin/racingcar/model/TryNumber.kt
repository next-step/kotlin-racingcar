package racingcar.model

data class TryNumber(
    val number: Int
) {
    init {
        require(number >= 0) { "경주 시도 횟수가 음수가 될수는 없습니다." }
    }

    fun minus(): TryNumber {
        return TryNumber(number - 1)
    }

    fun isZero(): Boolean {
        return number == 0
    }
}
