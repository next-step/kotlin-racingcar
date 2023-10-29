package step4.carRacingWinner.model


class Car(private var curPosition: Int = 0, private var carName: String = "") {
    fun tryRace(rule: () -> Boolean) {
        if (rule()) {
            curPosition++
        }
    }

    fun getCurPosition() = this.curPosition
    fun getCarName() = this.carName
}
