package domain.step4.domain.configuration

@JvmInline
value class NumberOfCars(val numberOfCars: Int) {
    init {
        require(numberOfCars >= MINIMUM) { String.format(OUT_OF_RANGE_MESSAGE, numberOfCars) }
    }

    constructor(numberOfCars: String) : this(numberOfCars.toInt())

    companion object {
        private const val MINIMUM = 1
        private const val OUT_OF_RANGE_MESSAGE = "NumberOfCars 가 허용하는 범위 밖의 숫자 %s가 입력 되었습니다."
    }
}
