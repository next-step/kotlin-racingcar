package racing.dto

data class RacingRecord(val trackResults: ArrayList<TrackResult> = ArrayList()) {
    fun add(trackResult: TrackResult) {
        trackResults.add(trackResult)
    }
}
