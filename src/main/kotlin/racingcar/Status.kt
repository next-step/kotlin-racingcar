package racingcar

enum class Status {
    READY,
    FINISHED;

    fun isReady(): Boolean {
        return this == READY
    }

    fun isFinished(): Boolean {
        return this == FINISHED
    }
}
