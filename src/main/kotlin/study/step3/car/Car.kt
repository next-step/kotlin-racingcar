package study.step3.car

class Car() {
    var currentLocation: Int = 1

    fun move(dice: Int) {
        if (canMove(dice)) {
            this.currentLocation += 1
        }
    }

    private fun canMove(dice: Int): Boolean {
        return dice >= 4
    }
}
