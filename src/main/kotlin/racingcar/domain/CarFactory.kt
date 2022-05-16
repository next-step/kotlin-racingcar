package racingcar.domain

/**
 * 클래스에 대한 설명을 적어주세요.
 * Created by Jaesungchi on 2022.05.16..
 */
object CarFactory {
    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }
}