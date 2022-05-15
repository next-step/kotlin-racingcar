package racinggame.domain.model

@JvmInline
value class RacingGameResult(val stepResults: List<RacingStepResult>) {
    val winners
        get() = stepResults.last().firstPlaces
}
