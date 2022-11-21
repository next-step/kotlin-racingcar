package racing.domain

class Position(
    var value: Int
) {

    fun move() {
        value++
    }
}
