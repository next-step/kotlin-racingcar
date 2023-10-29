package race.domain

class RacingCar {
    var space = 0
        private set

    fun go() {
        space += 1
    }
}
