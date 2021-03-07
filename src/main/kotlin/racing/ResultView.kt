package racing

fun printResult(record: Record) {
    record.records.forEach {
        println("-".repeat(it))
    }
    println()
}
