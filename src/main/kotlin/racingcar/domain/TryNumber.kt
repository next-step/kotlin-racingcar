package racingcar.domain

private const val MIN_TRY_NUMBER = 1

class TryNumber(
    private val value: Int,
) {
    init {
        require(value >= MIN_TRY_NUMBER) { "시도횟수는 1이상인 수만 입력받을 수 있습니다. value = $value" }
    }
}
