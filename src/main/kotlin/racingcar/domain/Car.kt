package racingcar.domain

data class Car(
    val name: String,
) {
    private var _distance = 0
    val distance get() = _distance

    fun takeAction() {
        _distance += Action.execute().distance
    }
}
