package step4.domain

import java.util.Random

object TryMoving {
    fun isSuccessfullyMoved(random: Int = getRandom()): Boolean {
        return random >= 4
    }

    private fun getRandom(): Int {
        val random = Random()
        return random.nextInt(10)
    }
}
