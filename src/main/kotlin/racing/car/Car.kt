package racing.car

data class Car(var position: Int = INIT_POSITION) {

    fun move() {
        position += ADD_POSITION
    }

    companion object {
        const val INIT_POSITION = 1
        const val ADD_POSITION = 1
    }
}
