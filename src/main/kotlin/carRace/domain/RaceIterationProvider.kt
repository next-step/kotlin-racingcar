package carRace.domain

interface RaceIterationProvider {
    fun provide(): Int

    class ManualRaceIterationProvider(private val iteration: Int) : RaceIterationProvider {
        override fun provide(): Int = iteration
    }
}
