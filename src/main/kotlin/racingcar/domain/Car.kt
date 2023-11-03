package racingcar.domain

class Car(
    private var position: Int = 0,
) {

    companion object {
        private const val FORWARD_CONDITION = 4
    }

    fun move(value: Int) {
        if (value >= FORWARD_CONDITION) {
            this.position += 1
        }
    }

    fun isPosition(position: Int): Boolean {
        return this.position == position
    }
}
