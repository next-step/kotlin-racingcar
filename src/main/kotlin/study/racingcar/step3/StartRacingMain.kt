package study.racingcar.step3

fun main() {
    val input = InputView()

    val racingCars = ParticipationCar(input.carCount).getRacingCars()

    for (i in 1..input.runCount) {
        RacingRun(racingCars).nextRun()
        ResultView(racingCars).show()
    }
}
