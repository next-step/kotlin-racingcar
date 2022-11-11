package step3

class Car {
    private var distance: Int = 0

    fun move(): Int {
        val number = (0..9).random()
        if (number >= 4) {
            distance += 1
        }
        return distance
    }
}
