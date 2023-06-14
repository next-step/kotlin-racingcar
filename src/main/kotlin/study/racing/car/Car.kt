package study.racing.car

class Car(
    val name: String,
    totalMoved: Int? = 0
) {
    var totalMoved = totalMoved ?: 0
        private set

    fun move(condition: Int) {
        if (condition >= 4) {
            totalMoved += 1
        }
    }
}
