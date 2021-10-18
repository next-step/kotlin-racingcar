package racingcar.domain

@JvmInline
value class NumberOfTrials private constructor(val value: Int) {
    companion object {
        private const val MINIMUM_NUMBER_OF_TRIALS = 1
        private const val MAXIMUM_NUMBER_OF_TRIALS = 20
        private const val ENTERED_WRONG_NUMBER_OF_TRIALS =
            "잘못된 시도 횟수가 입력되었습니다. $MINIMUM_NUMBER_OF_TRIALS 이상 $MAXIMUM_NUMBER_OF_TRIALS 이하의 숫자를 입력하세요."

        fun from(value: Int?): NumberOfTrials {
            require(value != null && value >= MINIMUM_NUMBER_OF_TRIALS && value <= MAXIMUM_NUMBER_OF_TRIALS) { ENTERED_WRONG_NUMBER_OF_TRIALS }
            return NumberOfTrials(value)
        }
    }
}
