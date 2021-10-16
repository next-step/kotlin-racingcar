import model.Car

/**
 * 자동차들의 객체 관리
 * */
class Cars(private val number: Int) {
    fun createCars(): List<Car> {
        return (0 until number).map { Car() }.toList()
    }
}
