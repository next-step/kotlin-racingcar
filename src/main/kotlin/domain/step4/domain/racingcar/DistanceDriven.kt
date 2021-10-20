package domain.step4.domain.racingcar

@JvmInline
value class DistanceDriven(val distanceDriven: Int = DEFAULT) {
    init {
        require(distanceDriven >= DEFAULT) { OUT_OF_RANGE_MESSAGE }
    }

    fun moveForward() = DistanceDriven(distanceDriven + INCREASE)

    companion object {
        private const val DEFAULT = 0
        private const val INCREASE = 1
        private const val OUT_OF_RANGE_MESSAGE = "DistanceDriven 가 허용하는 범위 밖의 숫자가 입력 되었습니다."
    }
}
