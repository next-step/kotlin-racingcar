package racingcar.domain

/**
 * 차량을 만들어주는 클래스
 * Created by Jaesungchi on 2022.05.16..
 */
object CarFactory {
    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }
}
