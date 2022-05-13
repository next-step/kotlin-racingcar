package racingcar.view

object ResultView {
    private const val DASH_VIEW = "-"

    fun showRecordsAsDash(driveRecords: List<Int>) {
        driveRecords.forEach { record ->
            repeat(record) {
                print(DASH_VIEW)
            }
            println()
        }
        println()
    }
}
