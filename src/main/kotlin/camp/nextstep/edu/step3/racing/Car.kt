package camp.nextstep.edu.step3.racing

import kotlin.random.Random

class Car(val id: Int, private val engine: Engine = RandomlyEngine()) {

    fun raceOn(track: Track, moveCount: Int) {
        for (i in 0 until moveCount) {
            if (engine.speed() > 0) track.markTrace()
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

    interface Engine {
        fun speed(): Int
    }

    private class RandomlyEngine : Engine {

        private val random = Random(Random.Default.nextInt())

        override fun speed(): Int {
            return if (random.nextInt(0, 10) >= 4) 1 else 0
        }
    }
}
