package race.domain

class RacingCar(val name: String) {
    var space = 0
        private set

    fun go() {
        space += 1
    }
}
