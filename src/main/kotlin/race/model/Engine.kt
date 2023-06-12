package race.model

interface Engine {
    fun cycle(): Int

    fun isRun() = cycle() >= MOVE_CONDITION

    companion object {
        const val MOVE_CONDITION = 4
    }
}
