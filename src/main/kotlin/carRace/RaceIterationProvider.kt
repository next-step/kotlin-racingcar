package carRace

interface RaceIterationProvider {
    fun provide(): Int

    class Manual(private val iteration: Int) : RaceIterationProvider {
        override fun provide(): Int = iteration
    }

    object UserInput : RaceIterationProvider {
        override fun provide(): Int {
            return println("시도할 횟수는 몇 회인가요?").run { readln().trim().toInt() }
        }
    }
}
