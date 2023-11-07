package racingcar.domain

data class Car(
    private val name: String,
    private var position: Int = 0,
) {

    val carName: String
        get() = this.name

    val currentPosition: Int
        get() = this.position

    fun move(value: Int) {
        if (value >= FORWARD_CONDITION) {
            this.position++
        }
    }

    companion object {
        private const val FORWARD_CONDITION = 4
    }
}
