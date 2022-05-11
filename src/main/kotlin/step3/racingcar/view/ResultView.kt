package step3.racingcar.view

object ResultView {
    private const val DASH_VIEW = '-'

    fun showRecordAsDash(driveRecord: Int) {
        for (i in 0 until driveRecord) {
            print(DASH_VIEW)
        }
        println()
    }
}
