package racingcar.domain

data class Car(
    val name: String,
    val distance: Int = 0
) {

    fun takeAction(): Car = this.copy(distance = Action.execute().distance)
}
