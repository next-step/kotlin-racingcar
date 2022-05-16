package racingcar

fun main() {
    val racingCarRequest: RacingCarRequest = RacingCarInputView.input()
    val racingResults = RaceHost.play(
        Rounds(racingCarRequest.rounds),
        racingCarRequest.numberOfParticipants
    )
    RacingCarOutputView.output(racingResults)
}
