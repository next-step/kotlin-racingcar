package racingcar.domain

class RandomNumberPicker {
    private val range = (MINIMUM_VALUE..MAXIMUM_VALUE)

    fun getNumber(): Moving {
        return Moving(range.random())
    }

    companion object {
        private const val MINIMUM_VALUE = 0
        private const val MAXIMUM_VALUE = 9
    }
}