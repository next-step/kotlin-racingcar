package racingcar.model

@JvmInline
value class CarCount(
    val count: Int
) {
    init {
        require(count > 0) { "적어도 하나의 자동차 대수를 넣어주세요." }
    }
}
