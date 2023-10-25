package step3.domain

import java.util.Random

object TryMoving {
    private fun getRandom(): Int {
        val random = Random()
        return random.nextInt(10)
    }

    fun isSuccessfullyMoved(random: Int = getRandom()): Boolean {
        return random >= 4
    }
}
