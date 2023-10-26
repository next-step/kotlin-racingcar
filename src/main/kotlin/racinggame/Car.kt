package racinggame

class Car(position: Int = 0) {
    var position: Int = position
        private set

    fun forward() {
        position += 1
    }
}
