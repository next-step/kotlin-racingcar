package step3.carRacing.model


class Car(private var curPosition: Int = 0) {
    fun tryRace(rule: () -> Boolean) {
        if (rule()) {
            curPosition++
        }
    }

    fun getCurPosition() = this.curPosition
}
