package racing.participant

class Racer(
    val name: String
) {
    var position: Int = 0
        private set

    fun move() {
        this.position++
    }
}