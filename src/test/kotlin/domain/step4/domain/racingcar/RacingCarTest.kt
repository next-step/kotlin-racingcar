package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingCarTest {

    @Test
    fun `RacingCar 가 조건을 만족한다면 1칸 이동한다`() {
        val name = Name("test")
        val racingCar = RacingCar(name) { true }
        val movedRacingCar = racingCar.moveForward()

        assertThat(movedRacingCar.distance).isEqualTo(1)
    }

    @Test
    fun `RacingCar 가 조건을 불만족시한다면 이동하지 않는다`() {
        val name = Name("test")
        val racingCar = RacingCar(name) { false }
        val movedRacingCar = racingCar.moveForward()

        assertThat(movedRacingCar.distance).isEqualTo(0)
    }

    @Test
    fun `동일한 주행거리와 움직임 전략을 갖고 있다면 동일한 객체이다`() {
        val name = Name("test")
        val movingStrategy = MovingStrategy { true }
        val one = RacingCar(name, movingStrategy = movingStrategy)
        val other = RacingCar(name, movingStrategy = movingStrategy)

        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) }
        )
    }

    @ParameterizedTest(name = "내 주행거리 : {0}, 다른이의 주행거리 : {1}, 예상 결과값 : {2}")
    @CsvSource(value = ["0:0:true", "1:0:true", "1:2:false", "99:100:false"], delimiter = ':')
    fun `다른 자동차의 주행거리보다 현 자동차의 주행거리가 같거나 큰지 비교한다`(myDistance: Int, otherDistance: Int, expected: Boolean) {
        val movingStrategy = MovingStrategy { true }
        val me = RacingCar(Name("me"), DistanceDriven(myDistance), movingStrategy)

        assertThat(me.isWinner(otherDistance)).isEqualTo(expected)
    }
}
