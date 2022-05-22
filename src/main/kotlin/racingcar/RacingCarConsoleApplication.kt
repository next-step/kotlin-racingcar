package racingcar

fun main() {
    val racingCarRequest: RacingCarRequest = RacingCarInputView.input()
    val racingResults = RaceHost.play(
        Rounds(racingCarRequest.rounds),
        CarNames.of(carNames = racingCarRequest.carNames),
    )
    RacingCarOutputView.output(racingResults)
}
