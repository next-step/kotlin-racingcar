package racingcar.domain.engine

data class CustomEngine(private val criterion: Int) : Engine {
    init {
        require(criterion in START_RANGE..END_RANGE)
    }

    override fun generateCriterionValueToRace(): Int {
        return criterion
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
    }
}
