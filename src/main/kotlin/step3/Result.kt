package step3

class Result {
    val records = mutableListOf<Int>()

    fun record(car: Car) {
        record(car.position)
    }

    private fun record(position: Int) {
        records.add(position)
    }
}
