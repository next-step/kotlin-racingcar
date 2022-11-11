package step3

class Car {
    var position = 0
        private set
    fun move(fuel: Int) {
        if (fuel >= 4) {
            this.position++
        }
    }
}
