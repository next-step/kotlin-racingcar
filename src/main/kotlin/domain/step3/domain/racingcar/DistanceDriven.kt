package domain.step3.domain.racingcar

@JvmInline
value class DistanceDriven(val distance: Int) {
    init {
        require(distance >= 0) { OUT_OF_RANGE_MESSAGE }
    }

    companion object {
        private const val MINIMUM = 0
        private const val OUT_OF_RANGE_MESSAGE = "DistanceDriven 가 허용하는 범위 밖의 숫자가 입력 되었습니다."
    }
}