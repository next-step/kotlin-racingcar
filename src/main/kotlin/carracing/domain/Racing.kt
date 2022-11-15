package carracing.domain

class Racing(var cars: Cars) {
    fun race(): Cars {
        return Cars(cars.map {
            it.move()
        })
    }
}
