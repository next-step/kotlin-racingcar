package racinggame

class Car(position: Int = 0) {
    var position: Int = position
        private set

    fun move(diceResult: Int) {
        position = CarCondition.getCondition(diceResult).apply(position)
    }
}

enum class CarCondition(val apply: (Int) -> Int) {
    STOP({ it }),
    FORWARD({ it + 1 });

    companion object {
        fun getCondition(diceResult: Int) = diceResult.let {
            if (it >= 4) {
                FORWARD
            } else {
                STOP
            }
        }
    }
}
