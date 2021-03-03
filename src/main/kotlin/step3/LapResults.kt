package step3

class LapResults(val lapResults: List<LapResult>) {
    fun size() = lapResults.size
    operator fun get(i: Int) = lapResults[i]
}
