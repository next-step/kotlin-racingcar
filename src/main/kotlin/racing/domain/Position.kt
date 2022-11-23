package racing.domain

class Position{
    var value: Int = 0
        private set

    fun move() {
        value++
    }
}
