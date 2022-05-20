package racing.model

import racing.dto.TrackResult

class RacingRecord {

    private val trackResults: ArrayList<TrackResult> = ArrayList()

    fun add(trackResult: TrackResult) {
        trackResults.add(trackResult)
    }

    fun getResults(): List<TrackResult> {
        return trackResults.toList()
    }
}
