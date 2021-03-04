package racinggame.car.domain

import kotlin.random.Random

class V8Engine : Engine {
    override fun enoughPower() = Random(SEED).nextInt(10) >= MIN_POWER

    companion object {
        private const val SEED = 17
        private const val MIN_POWER = 4
    }
}
