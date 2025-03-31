package racingcar.domain.numberpicker

class RandomNumberPicker : NumberPicker {
    override fun getNumber(): Int {
        return RANGE.random()
    }

    companion object {
        private const val MINIMUM_VALUE = 0
        private const val MAXIMUM_VALUE = 9
        private val RANGE = (MINIMUM_VALUE..MAXIMUM_VALUE)
    }
}
