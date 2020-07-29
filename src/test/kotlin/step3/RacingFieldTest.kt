package step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RacingFieldTest {
    @Test
    fun `시도횟수가 0미만인 경우 Exception`() {
        // given
        val cars = Cars(listOf(Car("car", CarMover())))
        val racingField = RacingField(cars)

        // then
        assertThatThrownBy { racingField.startRace(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 0이상이어야 합니다. 입력 값 : -1")
    }

    @Test
    fun `무조건 전진하는 자동차경주시 그 결과가 제대로 나오는지 확인`() {
        // given
        val car = Car(
            "car",
            object : Mover {
                override fun canMove(): Boolean {
                    return true
                }
            }
        )
        val cars = Cars(listOf(car))
        val racingField = RacingField(cars)
        val expectedRacingResults = listOf(
            RacingResult(listOf(RacingRecord("car", 1))),
            RacingResult(listOf(RacingRecord("car", 2)))
        )

        // when
        val racingResult = racingField.startRace(2)

        // then
        assertThat(racingResult).isEqualTo(expectedRacingResults)
    }
}
