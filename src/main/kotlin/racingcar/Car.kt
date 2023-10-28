package racingcar

data class Car(var position: Int = INIT_POSITION) {

    fun move() {
        position += 1
    }

    companion object {
        const val INIT_POSITION = 1
    }
}
