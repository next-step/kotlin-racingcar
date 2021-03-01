package racing.participant

class Racer(
    val sequence: Int
) {
    var position: Int = 0
        private set

    fun move() {
        this.position++
    }
}