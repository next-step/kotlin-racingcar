package racingcar.model

enum class MovingStatus {
    GO, STOP;

    companion object {
        val Collection<MovingStatus>.wentSize
            get() = count { it == GO }
    }
}
