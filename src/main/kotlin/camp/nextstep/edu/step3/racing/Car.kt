package camp.nextstep.edu.step3.racing

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
}
