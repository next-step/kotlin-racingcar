package carracing.view

import carracing.model.model.Snapshot

private const val MOVEMENT = "-"

object OutputView {
    fun printResult(snapshots: List<Snapshot>) {
        println("실행 결과")
        snapshots.forEach { printSnapshot(it) }
    }

    fun printSnapshot(snapshot: Snapshot) {
        snapshot.forEach { println(MOVEMENT.repeat(it)) }
        println()
    }
}
