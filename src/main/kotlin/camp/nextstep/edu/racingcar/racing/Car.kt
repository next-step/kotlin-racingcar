package camp.nextstep.edu.racingcar.racing

import kotlin.random.Random

class Car(val id: Int, val name: String, private val engine: Engine = RandomlyEngine()) {

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun race(): CarRaceEvent {
        return if (engine.speed() > 0) CarRaceEvent.movedEvent(id)
        else CarRaceEvent.stoppedEvent(id)
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
            return if (random.nextInt(POWER_MIN, POWER_MAX) >= MOVABLE_POWER_MIN) 1 else 0
        }

        companion object {
            private const val POWER_MIN = 0
            private const val POWER_MAX = 10
            private const val MOVABLE_POWER_MIN = 4
        }
    }
}
