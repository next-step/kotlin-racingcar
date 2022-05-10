package camp.nextstep.edu.step3.racing

import java.time.Instant.now
import kotlin.random.Random

class Car(val id: Int) {

    private val engine: Engine = Engine(id * now().nano)

    fun raceOn(track: Track, moveCount: Int) {
        for (i in 0 until moveCount) {
            if (engine.move()) track.markTrace()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }

    private class Engine(id: Int) {
        private val random = Random(id)
        fun move(): Boolean = random.nextInt(0, 10) >= 4
    }
}
