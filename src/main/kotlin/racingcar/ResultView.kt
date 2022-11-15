package racingcar

import racingcar.controller.RacingCarGameSnapShots

class ResultView(snapShots: RacingCarGameSnapShots) {
    val snapStopText: String

    init {
        this.snapStopText = toSnapShotsText(snapShots)
    }

    fun prettyPrint() {
        println(snapStopText)
    }

    private fun toSnapShotsText(snapShots: RacingCarGameSnapShots): String {
        return (1..snapShots.getNumberOfTrial())
            .map { prettyPrintATrial(snapShots.getPositions(it)) }
            .joinToString("\n\n")
    }

    private fun prettyPrintATrial(positions: List<Int>): String {
        return positions
            .map { (0 until it).map { "-" }.joinToString("") }
            .joinToString("\n")
    }
}
