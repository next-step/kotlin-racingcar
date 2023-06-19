package racingcar

class PositionHistory(val positions: List<Int>) {
    init {
        require(positions.all { it >= Car.DEFAULT_POSITION }) { "Car의 포지션은 ${Car.DEFAULT_POSITION} 이상이어야 합니다" }
    }
}
