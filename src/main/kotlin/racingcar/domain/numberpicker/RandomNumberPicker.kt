package racingcar.domain.numberpicker

class RandomNumberPicker : NumberPicker {
    private val range = (MINIMUM_VALUE..MAXIMUM_VALUE)

    override fun getNumber(): Int {
        return range.random()
    }

    companion object {
        private const val MINIMUM_VALUE = 0
        private const val MAXIMUM_VALUE = 9
    }
}
