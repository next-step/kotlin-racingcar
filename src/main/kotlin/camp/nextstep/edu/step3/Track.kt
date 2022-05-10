package camp.nextstep.edu.step3

class Track(private val length: Int) {
    private val traces: Array<Trace> = Array(length) { Trace() }
    private var onTraceIndex: Int = 0

    fun markTrace() {
        if (onTraceIndex >= length) throw RuntimeException("end of track; cannot mark trace more.")
        traces[onTraceIndex++].marked = true
    }

    fun isPassedAt(i: Int): Boolean {
        if (i < 0 || i >= length) throw IllegalArgumentException("$i is invalid index of track; trackLength=$length")
        return traces[i].marked
    }

    private class Trace {
        var marked: Boolean = false
    }
}
