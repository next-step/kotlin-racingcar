package racingcar

data class Rounds(val value: Int) {

    init {
        require(value >= MINIMUM_ROUNDS_VALUE) { "경주는 1회이상 진행해야 합니다. Rounds.value: $value" }
    }

    companion object {
        const val MINIMUM_ROUNDS_VALUE = 1;
    }
}
