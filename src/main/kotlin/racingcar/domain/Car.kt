package racingcar.domain

class Car(
    distance: Int = 0,
) {
    private var _distance = distance
    val distance get() = _distance

    fun takeAction() {
        _distance += Action.execute().distance
    }
}
