package racingcar.domain

@JvmInline
value class TryGames(val count: Int) {

    init {
        require(count > 0) { "경주는 1회 이상이어야 합니다" }
    }
}
