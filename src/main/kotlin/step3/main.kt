package step3

fun main() {
    val carCount = InputView.carCount()
    val executeCount = InputView.runCount()

    CarRacing().execute(
        carCount = carCount,
        executeCount = executeCount,
    )
}
