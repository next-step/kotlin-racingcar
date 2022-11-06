package racingcar

class ProgressView {

    fun display(progress: List<String>) {
        progress.forEach {
            println(it)
        }
        println()
    }
}
