package racingcar.model

data class CarCount(val count: Int) {

    init {
        require(count > 0) { "at least 1 count required" }
    }
}
