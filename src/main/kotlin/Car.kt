class Car(position: Int) {
    var position: Int = position
        private set

    fun move() {
        position += 1
    }
}
