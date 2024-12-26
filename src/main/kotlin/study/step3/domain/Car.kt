package study.step3.domain

import kotlin.random.Random

data class Car(
    val name: String,
    val engine: Engine,
) {
    var mileage: Mileage = Mileage(0)
        private set

    init {
        check(name.length <= MAX_CAR_NAME_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    fun move() {
        val rpm: Int = Random.nextInt(MAX_RPM + 1)
        mileage += engine.accelerate(rpm = rpm)
    }

    companion object {
        private const val MAX_RPM = 9
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
