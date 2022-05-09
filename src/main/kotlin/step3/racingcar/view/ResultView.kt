package step3.racingcar.view

object ResultView {
    private const val DASH_VIEW = "-"

    fun show(result: Int) {
        repeat(result) {
            print(DASH_VIEW)
        }
    }
}
