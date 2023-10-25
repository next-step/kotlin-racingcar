package step3.domain

import java.util.Random

object TryMoving {
    fun isSuccessfullyMoved(): Boolean {
        val random = Random()
        val num = random.nextInt(10)
        return num >= 4
    }
}
