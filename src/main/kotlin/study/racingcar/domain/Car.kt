package study.racingcar.domain

data class Car(val name: String, val position: Int = 0) {
    init {
        require(name.length <= 5) { "Car name cannot exceed 5 characters" }
    }
}
