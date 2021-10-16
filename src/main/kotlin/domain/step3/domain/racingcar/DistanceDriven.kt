package domain.step3.domain.racingcar

@JvmInline
value class DistanceDriven(val distanceDriven: Int = MINIMUM) {
    init {
        require(distanceDriven >= MINIMUM) { OUT_OF_RANGE_MESSAGE }
    }

    fun moveForward() = DistanceDriven(distanceDriven + INCREASE)

    companion object {
        private const val MINIMUM = 0
        private const val INCREASE = 1
        private const val OUT_OF_RANGE_MESSAGE = "DistanceDriven 가 허용하는 범위 밖의 숫자가 입력 되었습니다."
    }
}
