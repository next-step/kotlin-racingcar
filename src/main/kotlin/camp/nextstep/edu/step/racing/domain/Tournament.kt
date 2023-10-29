package camp.nextstep.edu.step.racing.domain

data class Tournament(
    val tournamentName: String = "",
    val track: RacingTrack,
    val tournamentInformation: TournamentInformation
) {
    init {
        require(tournamentName.isNotBlank()) { "대회 이름이 비어있습니다." }
        require(tournamentInformation.tryCount > 0) { "시도할 횟수가 0보다 작습니다." }
        require(track.trackName.isNotBlank()) { "트랙 이름이 비어있습니다." }
        require(tournamentInformation.cars.isNotEmpty()) { "참여하는 자동차가 없습니다." }
    }

    data class TournamentInformation(
        val cars: List<Car>,
        val tryCount: Int,
    )

    fun getCarListInTournament(): List<Car> {
        return tournamentInformation.cars
    }

    fun getCarListSize(): Int {
        return tournamentInformation.cars.size
    }

    fun getTryCount(): Int {
        return tournamentInformation.tryCount
    }

    companion object {
        fun of(
            tournamentName: String,
            track: RacingTrack,
            tournamentInformation: TournamentInformation
        ): Tournament {
            return Tournament(
                tournamentName = tournamentName,
                track = track,
                tournamentInformation = tournamentInformation
            )
        }
    }

}
