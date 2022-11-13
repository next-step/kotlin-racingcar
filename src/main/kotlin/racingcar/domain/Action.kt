package racingcar.domain

object Action {
    private const val NUM_FIRST = 0
    private const val NUM_MID = 4
    private const val NUM_LAST = 9

    enum class Type(val distance: Int) {
        STOP(0),
        GO(1);
    }

    fun execute(num: Int = RandomNumGenerator.generate(NUM_FIRST, NUM_LAST)): Type =
        if (num < NUM_MID) Type.STOP
        else Type.GO
}
