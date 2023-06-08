package racingcar.domain

class RandomState {
    private val range: IntRange = 0..9

    val randomInt: Int
        get() = range.random()
}
