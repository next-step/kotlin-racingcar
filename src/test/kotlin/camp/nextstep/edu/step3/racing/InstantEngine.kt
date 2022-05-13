package camp.nextstep.edu.step3.racing

class InstantEngine(n: Int) : Car.Engine {
    private val movables = mutableListOf<Int>()

    init {
        repeat(n) {
            movables.add(MOVABLE_SPEED)
        }
    }

    override fun speed(): Int {
        return if (movables.isNotEmpty()) movables.removeFirst()
        else NOT_MOVABLE_SPEED
    }

    companion object {
        private const val MOVABLE_SPEED = 9
        private const val NOT_MOVABLE_SPEED = 0
    }
}
