package study.step3

import kotlin.random.Random

data class Car(
    val name: String,
    val carEngine: CarEngine,
) {
    var mileage: Mileage = Mileage(0)
        private set

    fun move() {
        val rpm: Int = Random.nextInt(MAX_RPM + 1)
        mileage += carEngine.accelerate(rpm = rpm)
    }

    companion object {
        private const val MAX_RPM = 9
    }
}
