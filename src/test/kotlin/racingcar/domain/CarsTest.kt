package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.view.response.CarSnapShot

class CarsTest {

    @Test
    fun `Cars 2대 미만 생성시 예외`() {
        assertThrows<IllegalArgumentException> { Cars(listOf(Car("dd.kim"))) }
            .also { assertThat(it.message).isEqualTo("자동차 대수는 2대 이상이어야 합니다.") }
    }

    @Test
    fun `1바퀴 결과 추출`() {
        val moveStrategy = TestMoveStrategy()
        val position1Car = Car("jjj").also { it.move() }
        val position2Car = Car("bumblebee").also { it.move() }.also { it.move() }
        val position3Car = Car("dd.kim").also { it.move() }.also { it.move() }.also { it.move() }

        val cars = Cars(listOf(position1Car, position2Car, position3Car))
        val repsResult = cars.play1Reps(moveStrategy)

        assertThat(repsResult.snapShots).extracting(CarSnapShot::name, CarSnapShot::position)
            .containsExactly(
                Tuple.tuple("jjj", 2),
                Tuple.tuple("bumblebee", 3),
                Tuple.tuple("dd.kim", 4),
            )
    }

    @Test
    fun `Cars 우승자 추출`() {
        val position1Car = Car("jjj").also { it.move() }
        val position2Car = Car("bumblebee").also { it.move() }.also { it.move() }
        val position3Car = Car("dd.kim").also { it.move() }.also { it.move() }.also { it.move() }

        val cars = Cars(listOf(position1Car, position2Car, position3Car))

        assertThat(cars.findWinners()).extracting(Car::name)
            .containsExactly(
                Tuple.tuple("dd.kim")
            )
    }

    class TestMoveStrategy : MoveStrategy {
        override fun move(car: Car) {
            car.move()
        }
    }
}