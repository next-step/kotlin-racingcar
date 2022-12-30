package domain

class Car(
    val name: String,
    var distance: Int = 0
) {
    fun move(number: Int): Int {
        return if (number > 5) drive()
        else stop()
    }

    private fun drive(): Int {
        distance++
        return distance
    }

    private fun stop(): Int {
        return distance
    }
}