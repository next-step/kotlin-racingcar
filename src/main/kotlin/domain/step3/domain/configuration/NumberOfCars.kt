package domain.step3.domain.configuration

@JvmInline
value class NumberOfCars(val numberOfCars: Int) {
    init {
        require(numberOfCars >= MINIMUM) { OUT_OF_RANGE_MESSAGE }
    }

    constructor(numberOfCars: String) : this(numberOfCars.toInt())

    companion object {
        private const val MINIMUM = 1
        private const val OUT_OF_RANGE_MESSAGE = "NumberOfCars 가 허용하는 범위 밖의 숫자가 입력 되었습니다."
    }
}
