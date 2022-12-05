package racingcar

import racingcar.controller.RacingCarGameSnapShots

object ResultView {
    fun prettyPrint(snapShots: RacingCarGameSnapShots) {
        println(toSnapShotsText(snapShots))
    }

    fun toSnapShotsText(snapShots: RacingCarGameSnapShots): String {
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
