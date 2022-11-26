package racing.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CarRacingTest {

    @Test
    fun `자동차 경주 생성 테스트`() {
        // given
        val namesOfCars = listOf("car1", "car2", "car3").map(::Name)

        // when
        val carRacing = CarRacing(
            numOfMove = 10,
            namesOfCars = namesOfCars,
            moveStrategy = moveStrategy,
        )

        // then
        assertEquals(namesOfCars.sorted(), carRacing.carInfos.map(CarInfo::name).sorted())
        assertTrue(carRacing.carInfos.all { it.position == 0 })
    }

    @ParameterizedTest(name = "numOfMove: {0}")
    @ValueSource(strings = ["-10", "-1", "0"])
    fun `자동차 경주 생성시 경주횟수가 1보다 작을 경우 에러 테스트`(numOfMove: Int) {

        // when & then
        Assertions.assertThatThrownBy {
            CarRacing(
                numOfMove = numOfMove,
                namesOfCars = listOf("car1", "car2", "car3").map(::Name),
                moveStrategy = moveStrategy,
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `move 함수를 호출하면 내부의 자동차들이 이동한다`() {
        // given
        val carRacing = CarRacing(
            numOfMove = 10,
            namesOfCars = listOf("car1", "car2", "car3").map(::Name),
            moveStrategy = moveStrategy,
        )

        // when
        carRacing.move()

        // then
        assertTrue(carRacing.carInfos.all { it.position == MOVE_SIZE })
    }

    @ParameterizedTest(name = "numOfMove: {0}, actualNumOfMove: {1}, result: {2}")
    @CsvSource("10,9,false", "10,10,true", "1,0,false", "1,1,true")
    fun `자동차 경주 끝났는지 반환하는 테스트`(numOfMove: Int, actualNumOfMove: Int, result: Boolean) {
        // given
        val carRacing = CarRacing(
            numOfMove = numOfMove,
            namesOfCars = listOf("car1", "car2", "car3").map(::Name),
            moveStrategy = moveStrategy,
        )

        // when
        for (i in 1..actualNumOfMove) {
            carRacing.move()
        }

        // then
        assertEquals(result, carRacing.finish)
    }

    @ParameterizedTest(name = "numOfMove: {0}, actualNumOfMove: {1}")
    @CsvSource("10,11", "10,12", "1,2", "1,3")
    fun `자동차 경주 끝났는데 경주를 지속하는 경우 에러 테스트`(numOfMove: Int, actualNumOfMove: Int) {
        // given
        val carRacing = CarRacing(
            numOfMove = numOfMove,
            namesOfCars = listOf("car1", "car2", "car3").map(::Name),
            moveStrategy = moveStrategy,
        )

        // when & then
        Assertions.assertThatThrownBy {
            for (i in 1..actualNumOfMove) {
                carRacing.move()
            }
        }.isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun `우승 자동차 목록 반환 테스트`() {
        // given
        val namesOfCars = listOf("car1", "car2", "car3").map(::Name)
        val carRacing = CarRacing(
            numOfMove = 1,
            namesOfCars = namesOfCars,
            moveStrategy = moveStrategy,
        )
        carRacing.move()

        // when
        val winnerCarInfos = carRacing.winnerCarInfos

        // then
        assertEquals(namesOfCars.sorted(), winnerCarInfos.map(CarInfo::name).sorted())
    }

    @Test
    fun `우승 자동차 목록 반환시 경주가 끝나지 않은 경우 에러 테스트`() {
        // given
        val numOfMove = 10
        val carRacing = CarRacing(
            numOfMove = numOfMove,
            namesOfCars = listOf("car1", "car2", "car3").map(::Name),
            moveStrategy = moveStrategy,
        )

        for (i in 1 until numOfMove) {
            carRacing.move()
        }

        // when & then
        Assertions.assertThatThrownBy {
            carRacing.winnerCarInfos
        }.isInstanceOf(IllegalStateException::class.java)
    }

    companion object {
        const val MOVE_SIZE = 1

        val moveStrategy = MoveStrategy { MOVE_SIZE }
    }
}
