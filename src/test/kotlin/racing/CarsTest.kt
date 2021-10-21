package racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@Suppress("NonAsciiCharacters")
class CarsTest {

    @Test
    fun `비어있는 Cars는 생성될 수 없다`() {
        assertThatThrownBy {
            Cars(emptyList())
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car는 하나 이상 존재해야합니다")
    }

    @Test
    fun `차들을 이동시키면 이동에 성공한 차는 이동하고, 실패한 차는 이동하지 않는다`() {
        val cars = Cars(listOf(Car(goEngine, CarName("name1")), Car(stopEngine, CarName("name2"))))

        cars.goAll()

        assertAll(
            { assertThat(cars.cars[0].position).isEqualTo(Position(1)) },
            { assertThat(cars.cars[1].position).isEqualTo(Position(0)) },
        )
    }

    @Test
    fun `가장 앞서있는 차가 우승자다`() {
        val winnerName = CarName("win")
        val cars = Cars(listOf(Car(winnerName, 5), Car("lose1", 4), Car("lose2", 2)))

        val result = cars.getWinner().cars

        assertAll(
            { assertThat(result).hasSize(1) },
            { assertThat(result.first().name).isEqualTo(winnerName) },
        )
    }

    @Test
    fun `가장 앞서있는 차가 여러 대라면 모두 우승자이다`() {
        val winnerNames = listOf(CarName("win1"), CarName("win2"), CarName("win3"))
        val winningPosition = 5
        val cars = Cars(listOf(Car(winnerNames[0], winningPosition), Car(winnerNames[1], winningPosition), Car(winnerNames[2], winningPosition), Car("loser", 3)))

        val result = cars.getWinner().cars

        assertAll(
            { assertThat(result).hasSize(3) },
            { assertThat(result.map { it.name }).isEqualTo(winnerNames) },
            { assertThat(result.map { it.position }).containsOnly(Position(winningPosition)) },
        )
    }
}
