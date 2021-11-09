package racingcar.domain.cars

class GameStartLab(startLab: Int = START_LAB) {
    var value: Int = startLab
        private set

    init {
        require(START_LAB <= value)
    }

    fun increase() {
        value++
    }

    companion object {
        private const val START_LAB = 0
    }
}
