package racingcar.domain.engine

data class CustomEngine(private val cylinder: Int) : Engine {
    init {
        require(cylinder in START_RANGE..END_RANGE)
    }

    override fun cylinder(): Int {
        return cylinder
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
    }
}
