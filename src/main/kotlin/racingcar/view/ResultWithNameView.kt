package racingcar.view

import racingcar.domain.CarSnapShot
import racingcar.domain.RacingCarGameSnapShots

object ResultWithNameView {

    fun prettyPrint(snapShots: RacingCarGameSnapShots) {
        println(toSnapShotsText(snapShots))
    }

    fun toSnapShotsText(snapShots: RacingCarGameSnapShots): String {
        return """
            |${printGame(snapShots)}
            |
            |${printWinner(snapShots.winnerOfGame.map { it.name })}
            |
            """.trimMargin()
    }

    private fun printGame(snapShots: RacingCarGameSnapShots): String {
        return snapShots.snapShots
            .joinToString("\n\n") { printCarSnapshots(it.carSnapShots) }
    }

    private fun printWinner(winnerNames: List<String>): String {
        return "${winnerNames.joinToString(", ")}가 최종 우승했습니다."
    }

    private fun printCarSnapshots(snapshots: List<CarSnapShot>): String {
        return snapshots
            .joinToString("\n") {
                "${it.name} : ${"-".repeat(it.position)}"
            }
    }
}
