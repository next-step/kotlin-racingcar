package _3_racing_car.domain

data class Position(var value: Int) {
    private val initPosition = 0
    private val plusPosition = 1

    init {
        validate(value)
    }

    private fun validate(value: Int) {
        require(value >= initPosition) { "유효하지 않은 값입니다. value=$value" }
    }

    fun forward(value: Int = plusPosition) {
        this.value += value
    }
}
