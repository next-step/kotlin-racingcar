package racingcar

@JvmInline
value class NumberOfCars private constructor(val value: Int) {
    companion object {
        private const val MINIMUM_NUMBER_OF_CARS = 1
        private const val MAXIMUM_NUMBER_OF_CARS = 9
        private const val ENTERED_WRONG_NUMBER_OF_CARS =
            "잘못된 자동차 대수가 입력되었습니다. $MINIMUM_NUMBER_OF_CARS 이상 $MAXIMUM_NUMBER_OF_CARS 이하의 숫자를 입력하세요."

        fun from(value: Int?): NumberOfCars {
            require(value != null && value >= MINIMUM_NUMBER_OF_CARS && value <= MAXIMUM_NUMBER_OF_CARS) { ENTERED_WRONG_NUMBER_OF_CARS }
            return NumberOfCars(value)
        }
    }
}
