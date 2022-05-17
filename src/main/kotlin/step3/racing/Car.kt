package step3.racing

class Car(val name: String) {
    var distance: Int = 0
        private set

    private fun move() {
        distance += 1
    }

    private fun isMoved() = RandomGenerator.getInt(0, 9) >= 4

    fun run(isMoved: Boolean = isMoved()) {
        if (isMoved) move()
    }
}
