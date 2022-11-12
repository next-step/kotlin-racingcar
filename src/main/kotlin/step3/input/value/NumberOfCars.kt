package step3.input.value

data class NumberOfCars(private val numberOfCars: Int) {
    init {
        require(numberOfCars > 1) { "자동차 대수는 1보다 커야 합니다." }
    }

    fun getNumberOfCars(): Int {
        return numberOfCars
    }
}
