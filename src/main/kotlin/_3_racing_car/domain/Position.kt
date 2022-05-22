package _3_racing_car.domain

class Position(value: Int) {
    var value = value
        private set

    init {
        validate(value)
    }

    private fun validate(value: Int) = require(value >= INIT_POSITION) { "유효하지 않은 값입니다. value=$value" }

    fun forward(value: Int = PLUS_POSITION) {
        this.value += value
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val PLUS_POSITION = 1
    }
}
