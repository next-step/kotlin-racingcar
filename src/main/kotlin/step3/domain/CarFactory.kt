package step3.domain

class CarFactory(carCount: Int, val carList: List<Car> = ((0 until carCount).map { Car() }).toList())
