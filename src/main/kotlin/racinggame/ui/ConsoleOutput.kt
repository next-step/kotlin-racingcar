package racinggame.ui

import racinggame.record.Record
import racinggame.record.Recorder
import racinggame.record.Records

fun showResult(recorder: Recorder) {
    println("실행 결과")
    for (records in recorder.records) {
        records.toView()
    }
    printWinner(recorder.getWinners())
}

private fun printWinner(records: List<Record>) {
    records.joinToString { it.name }
        .run { println(toString() + "가 최종 우승했습니다.") }
}

private fun Records.toView() {
    for (record in records) {
        println(record.toView())
    }
    println()
}

private fun Record.toView() = with(StringBuilder()) {
    append("$name : ")
    repeat(distance) { append("-") }
    toString()
}
