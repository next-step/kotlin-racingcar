package study.racingcar.application

/**
 * 입력받은 자동차 대수와 시도 횟수가 유효한지 검증한다.
 * */
data class InputValue(
    val carTotalNum: Int,
    val tryCount: Int) {
    fun validate() {
        if (carTotalNum < 1 || tryCount < 1) {
            throw IllegalArgumentException("자동차 대수와 시도 횟수는 1 이상이어야 합니다.")
        }
    }
}
