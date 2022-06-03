package racingcar.repository

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class CarRepositoryTest {
    @Test
    fun save() {
        val carRepository = CarRepository()

        val car = Car("dd.kim").also { it.move() }
        carRepository.save(car)
        carRepository.save(Car("kyle"))
        carRepository.save(Car("bumblebee"))

        assertThat(carRepository.findAll()).hasSize(3)
            .extracting(Car::name, Car::position)
            .containsExactly(
                Tuple.tuple("dd.kim", 1),
                Tuple.tuple("kyle", 0),
                Tuple.tuple("bumblebee", 0)
            )
    }

    @Test
    fun update() {
        val carRepository = CarRepository()

        val car = Car("dd.kim").also { it.move() }
        carRepository.save(car)
        carRepository.save(Car("kyle"))
        carRepository.save(Car("dd.kim"))

        assertThat(carRepository.findAll()).hasSize(2)
            .extracting(Car::name, Car::position)
            .containsExactlyInAnyOrder(
                Tuple.tuple("dd.kim", 0),
                Tuple.tuple("kyle", 0),
            )
    }
}
