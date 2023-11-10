package carracing.view

import carracing.domain.Snapshot

private const val MOVEMENT = "-"

object OutputView {
    fun printResult(snapshots: List<Snapshot>) {
        println("실행 결과")
        snapshots.forEach { printSnapshot(it) }
    }

    fun printSnapshot(snapshot: Snapshot) {
        snapshot.trace.forEach { println("${it.key} : ${MOVEMENT.repeat(it.value)}") }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("${winners.joinToString(separator = ", ")}가 최종 우승했습니다.")
    }
}
