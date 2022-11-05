package racingcar.domain

data class Car(
    var route: String = "-"
) {
    companion object {
        fun make(count: Long) =
            mutableListOf<Car>().apply {
                for (i in 0 until count) {
                    this.add(Car())
                }
            }
    }

    fun move() {
        this.route += "-"
    }
}
