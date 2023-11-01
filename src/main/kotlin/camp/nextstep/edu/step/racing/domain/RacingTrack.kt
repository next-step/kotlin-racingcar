package camp.nextstep.edu.step.racing.domain

@JvmInline
value class RacingTrack private constructor(
    val trackName: String = ""
) {
    init {
        require(trackName.isNotBlank()) { "경주장의 이름이 비어있습니다." }
    }

    companion object {
        fun of(trackName: String): RacingTrack {
            return RacingTrack(trackName = trackName)
        }
    }

}
