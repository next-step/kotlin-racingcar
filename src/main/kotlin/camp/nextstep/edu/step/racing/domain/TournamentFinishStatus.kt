package camp.nextstep.edu.step.racing.domain

@JvmInline
value class TournamentFinishStatus private constructor(
    private val tournamentStatus: Boolean
) {
    companion object {
        fun activeTrue(): TournamentFinishStatus {
            return TournamentFinishStatus(tournamentStatus = true)
        }
    }

    fun getTournamentStatus(): Boolean {
        return tournamentStatus
    }

}
