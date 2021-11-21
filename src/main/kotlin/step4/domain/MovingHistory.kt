package step4.domain

/**
 *
 * @author Leo
 */
class MovingHistory(val owner: CarName) {

    companion object {
        val EMPTY = ""
        val COLON = ":"
        val SPACE = " "
        val BAR = "-"
        val SEPERATOR = "$SPACE$COLON$SPACE"
    }

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

    fun getForwardCount() = this.history.count { it }

    private fun convertLogToProgressBar(count: Int): String {
        var bar = EMPTY
        for (index in 0 until count) {
            val moved = if (history[index]) BAR else EMPTY
            bar = bar.plus(moved)
        }

        return "${owner.name}$SEPERATOR$bar"
    }
}
