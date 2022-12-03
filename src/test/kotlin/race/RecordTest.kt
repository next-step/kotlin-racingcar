package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RecordTest {

    @Test
    fun `단일 우승자 차 이름 추출 성공`() {
        // Arrange
        val round = 3
        val carNames: List<String> = listOf("a", "b", "c")
        val carMoved = listOf(
            mutableListOf(true, true, true),
            mutableListOf(true, false, false),
            mutableListOf(true, false, false),
        )
        val cars: List<Car> = carNames.mapIndexed { index, name -> Car(name, carMoved[index]) }

        val snapShot = SnapShot(round, cars)
        val record = Record(listOf(snapShot))

        // Act & Assert
        assertThat(listOf("a")).isEqualTo(record.getWinnerCarName())
    }

    @Test
    fun `다수 우승자 차 이름 추출 성공`() {
        // Arrange
        val round = 3
        val carNames: List<String> = listOf("a", "b", "c")
        val carMoved = listOf(
            mutableListOf(true, true, true),
            mutableListOf(true, true, true),
            mutableListOf(true, false, false),
        )
        val cars: List<Car> = carNames.mapIndexed { index, name -> Car(name, carMoved[index]) }

        val snapShot = SnapShot(round, cars)
        val record = Record(listOf(snapShot))

        // Act & Assert
        assertThat(listOf("a", "b")).isEqualTo(record.getWinnerCarName())
    }
}
