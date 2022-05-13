package raicing.model

data class Car(val id: Int) {
    var position: Int = 0
        private set

    fun moveForward() {
        position++
    }
}
