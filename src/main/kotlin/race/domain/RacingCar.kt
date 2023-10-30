package race.domain

class RacingCar(val name: String) {
    var space = 0
        private set
    var isWinner = false
        private set

    fun go() {
        space += 1
    }

    fun win() {
        isWinner = true
    }
}
