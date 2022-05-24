package racingcar

fun main() {
    val racingCarRequest: RacingCarRequest = RacingCarInputView.input()
    val racingResults = RaceHost.play(
        racingCarRequest.rounds,
        carNames = racingCarRequest.carNames,
    )
    RacingCarOutputView.output(racingResults)
}
