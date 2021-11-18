package step3.domain

/**
 *
 * @author Leo
 */
class MovingHistory {

    private val history = mutableListOf<Boolean>()

    fun log(moved: Boolean) {
        history.add(moved)
    }

    fun getProgressBars(): List<String> {
        val totalCount = history.size
        val progressBars = mutableListOf<String>()
        for (count in 1..totalCount) {
            progressBars.add(convertLogToProgressBar(count))
        }

        return progressBars
    }

    private fun convertLogToProgressBar(count: Int): String {
        var bar = ""
        for (index in 0 until count) {
            val moved = if (history[index]) "-" else ""
            bar = bar.plus(moved)
        }

        return bar
    }

}
