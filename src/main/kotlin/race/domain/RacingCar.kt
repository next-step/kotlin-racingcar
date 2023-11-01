package race.domain

class RacingCar(val name: String, space: Int = 0) {
    var space = space
        private set

    fun go() {
        space += 1
    }
}
