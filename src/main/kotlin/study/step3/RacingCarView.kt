package study.step3

data class RacingCarView(
    val moved: Int,
    val state: String
)

internal val RacingCar.view
    get() = RacingCarView(
        moved = this.getMoved(),
        state = "-".repeat(this.getMoved())
    )