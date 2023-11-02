package racinggame.domain

class Car(
    val name: String,
    position: Int = 0
) {

    init {
        require(name.length in 1..5) {
            "자동차 이름은 1~5자만 가능합니다."
        }
    }

    var position: Int = position
        private set

    fun move(diceResult: DiceResult) {
        position = diceResult.apply(position)
    }
}

