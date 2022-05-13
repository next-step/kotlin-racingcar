package camp.nextstep.edu.step3.racing

class Track(private val length: Int) {
    private val traces: Array<Trace> = Array(length) { Trace() }
    private var onTraceIndex: Int = 0

    fun markTrace() {
        check(onTraceIndex < length) { "end of track; cannot mark trace more." }
        traces[onTraceIndex++].marked = true
    }

    fun traces(): Iterator<Boolean> = traces.map { it.marked }.iterator()

    private class Trace {
        var marked: Boolean = false
    }
}
