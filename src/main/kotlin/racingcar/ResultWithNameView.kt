package racingcar

import racingcar.controller.CarSnapShot
import racingcar.controller.RacingCarGameSnapShots

object ResultWithNameView {

    fun prettyPrint(snapShots: RacingCarGameSnapShots) {
        println(toSnapShotsText(snapShots))
    }

    fun toSnapShotsText(snapShots: RacingCarGameSnapShots): String {
        return printGame(snapShots)
            .plus("\n\n")
            .plus(printWinner(snapShots))
            .plus("\n")
    }

    private fun printGame(snapShots: RacingCarGameSnapShots): String {
        return snapShots.snapShots
            .map { printCarSnapshots(it.carSnapShots) }
            .joinToString("\n\n")
    }

    private fun printWinner(snapShots: RacingCarGameSnapShots): String {
        val lastCarSnapshots = snapShots.snapShots.last().carSnapShots
        val winnerPosition = lastCarSnapshots.maxOfOrNull { it.position }

        return lastCarSnapshots
            .filter { it.position == winnerPosition }
            .map { it.name }
            .joinToString(", ")
            .plus("가 최종 우승했습니다.")
    }

    private fun printCarSnapshots(snapshots: List<CarSnapShot>): String {
        return snapshots
            .map {
                val positionPrint = (0 until it.position).map { "-" }.joinToString("")
                "${it.name} : $positionPrint"
            }
            .joinToString("\n")
    }
}
