package racing

data class CarsDto(val cars: List<CarDto>) {
    constructor(cars: Cars) : this(cars.cars.map(::CarDto))
}

data class CarDto(val name: String, val position: Int) {
    constructor(car: Car) : this(car.name.value, car.position.value)
}
