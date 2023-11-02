package carracing.view

import carracing.model.model.Snapshot

object OutputView {
    fun printResult(snapshots: List<Snapshot>) {
        println("실행 결과")
        snapshots.forEach { println(it) }
    }
}
