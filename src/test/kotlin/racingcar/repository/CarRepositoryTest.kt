package racingcar.repository

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class CarRepositoryTest {
    @Test
    fun save() {
        val carRepository = CarRepository()

        val car = Car(1)
        car.move()
        carRepository.save(car)
        carRepository.save(Car(2))
        carRepository.save(Car(3))

        assertThat(carRepository.findAll()).hasSize(3)
            .extracting(Car::id, Car::position)
            .containsExactly(
                Tuple.tuple(1, 1),
                Tuple.tuple(2, 0),
                Tuple.tuple(3, 0)
            )
    }

    @Test
    fun update() {
        val carRepository = CarRepository()

        val car = Car(1).also { it.move() }
        carRepository.save(car)
        carRepository.save(Car(2))
        carRepository.save(Car(1))

        assertThat(carRepository.findAll()).hasSize(2)
            .extracting(Car::id, Car::position)
            .containsExactlyInAnyOrder(
                Tuple.tuple(1, 0),
                Tuple.tuple(2, 0),
            )
    }
}
