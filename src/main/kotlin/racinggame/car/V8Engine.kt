package racinggame.car

import java.util.Random

class V8Engine : Engine {
    override fun enoughPower() = Random().nextInt(10) >= MIN_POWER

    companion object {
        private const val MIN_POWER = 4
    }
}
