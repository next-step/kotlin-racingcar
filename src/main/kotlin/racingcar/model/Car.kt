package racingcar.model

class Car(
    private var distance: Int = 0
) {
    fun move(offset: Int = 1) {
        distance += offset
    }

    fun currentDistance(): Int {
        return distance
    }
}
