package racingcar.domain

object OilStation {
    private val RANDOM_RANGE = (0..9)

    fun generateOilRandomly(): Oil {
        return Oil(amount = RANDOM_RANGE.random())
    }
}
