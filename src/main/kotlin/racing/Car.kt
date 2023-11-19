package racing

data class Car(
    val name: String,
    var route: Int = 0
) {
    fun forward(movingRule: RacingMovingRule) {
        if (movingRule.isMove())
            route += 1
    }
}
