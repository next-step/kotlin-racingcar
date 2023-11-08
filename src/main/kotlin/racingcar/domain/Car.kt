package racingcar.domain

data class Car(
    val name: String,
) {

    var position: Int = 0
        private set

    constructor(name: String, position: Int) : this(name) {
        this.position = position
    }

    fun move(value: Int) {
        if (value >= FORWARD_CONDITION) {
            this.position++
        }
    }

    companion object {
        private const val FORWARD_CONDITION = 4
    }
}
