package racingcar.model

data class Car(private val gps: Gps = Gps(), private val powerEngine: PowerEngine = PowerEngine()) {

    fun tryMove(isForce: Boolean = false) {
        if (powerEngine.canGo() || isForce) gps.update()
    }

    fun whereIs() = gps.getCurrentState()
}
