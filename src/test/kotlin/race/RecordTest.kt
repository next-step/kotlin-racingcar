package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RecordTest {

    @Test
    fun `단일 우승자 차 이름 추출 성공`() {
        // Arrange
        val round = 3
        val carA = Car("A")
        val carB = Car("B")
        val carC = Car("C")
        carA.move(7)
        carA.move(7)
        carA.move(7)

        carB.move(7)
        carB.move(0)
        carB.move(0)

        carC.move(7)
        carC.move(0)
        carC.move(0)

        val carASnapShot = SnapShot(round, carA.name, carA.movements)
        val carBSnapShot = SnapShot(round, carB.name, carB.movements)
        val carCSnapShot = SnapShot(round, carC.name, carC.movements)
        val record = Record(listOf(carASnapShot, carBSnapShot, carCSnapShot))

        // Act & Assert
        assertThat(listOf("A")).isEqualTo(record.getWinnerCarName())
    }

    @Test
    fun `다수 우승자 차 이름 추출 성공`() {
        // Arrange
        val round = 3
        val carA = Car("A")
        val carB = Car("B")
        val carC = Car("C")
        carA.move(7)
        carA.move(7)
        carA.move(7)

        carB.move(7)
        carB.move(7)
        carB.move(7)

        carC.move(7)
        carC.move(0)
        carC.move(0)

        val carASnapShot = SnapShot(round, carA.name, carA.movements)
        val carBSnapShot = SnapShot(round, carB.name, carB.movements)
        val carCSnapShot = SnapShot(round, carC.name, carC.movements)
        val record = Record(listOf(carASnapShot, carBSnapShot, carCSnapShot))

        // Act & Assert
        assertThat(listOf("A", "B")).isEqualTo(record.getWinnerCarName())
    }
}
