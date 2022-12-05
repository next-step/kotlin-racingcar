package racingcar

import racingcar.controller.CarSnapShot
import racingcar.controller.RacingCarGameSnapShots

object ResultWithNameView {

    fun prettyPrint(snapShots: RacingCarGameSnapShots) {
        println(toSnapShotsText(snapShots))
    }

    fun toSnapShotsText(snapShots: RacingCarGameSnapShots): String {
        return snapShots.snapShots
            .map { printCarSnapshots(it.carSnapShots) }
            .joinToString("\n\n")
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
