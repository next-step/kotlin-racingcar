package racingcar

class Car {
    var position: Int = DEFAULT_POSITION
        private set

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
