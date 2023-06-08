package study.step3.car

interface CarFactory {
    fun createCars(numberOfCars: Int): List<Car>
}
