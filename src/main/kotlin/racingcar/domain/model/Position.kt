package racingcar.domain.model

data class Position(val count: Int) {

    init {
        require(count >= 0) { "위치는 0보다 크거나 같아야 합니다" }
    }

    operator fun inc(): Position {
        return Position(count.inc())
    }
}
