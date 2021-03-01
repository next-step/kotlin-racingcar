package racingcar.model

data class Car(private val gps: Gps = Gps()) {

    companion object {
        fun createCar() = Car()
    }

    fun tryMove(canGo: Boolean) {
        if (canGo) gps.update(1)
    }

    fun whereIs() = gps.getCurrentState()
}
