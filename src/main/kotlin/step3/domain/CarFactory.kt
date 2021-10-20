package step3.domain

class CarFactory(carCount: Int, val carList: List<Car> = ((0..carCount).map { Car() }).toList())
