package racinggame.ui

import racinggame.record.Record
import racinggame.record.Recorder
import racinggame.record.Records

fun showResult(recorder: Recorder) {
    println("실행 결과")
    for (records in recorder.records) {
        records.toView()
    }
}

fun Records.toView() {
    for (record in records) {
        println(record.toView())
    }
    println()
}

fun Record.toView() = with(StringBuilder()) {
    append("$name : ")
    repeat(distance) { append("-") }
    toString()
}
