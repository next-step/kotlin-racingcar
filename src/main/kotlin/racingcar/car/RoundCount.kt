package racingcar.car

class RoundCount(val count: Int) {

    init {
        require(count > 0) { "시도할 회수는 1 이상이어야 합니다." }
    }
}
