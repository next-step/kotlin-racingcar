package racinggame

class Car(position: Int = 0) {
    var position: Int = position
        private set

    fun move(diceResult: DiceResult) {
        position = diceResult.apply(position)
    }
}

