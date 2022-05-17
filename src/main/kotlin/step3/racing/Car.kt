package step3.racing

private const val MOVING_CONDITION = 4

class Car(val name: String) {
    var distance: Int = 0
        private set

    private fun move() {
        distance += 1
    }

    fun run(input: Int) {
        if (input >= MOVING_CONDITION) move()
    }
}
