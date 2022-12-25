package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import race.view.Output

class RecordTest {

    @Test
    fun `단일 우승자 차 이름 추출 성공`() {
        // Arrange
        val round = 3
        val carA = Car("A")
        val carB = Car("B")
        val carC = Car("C")

        val carARound1 = SnapShot(round, carA.name, true)
        val carARound2 = SnapShot(round, carA.name, true)
        val carARound3 = SnapShot(round, carA.name, true)

        val carBRound1 = SnapShot(round, carB.name, true)
        val carBRound2 = SnapShot(round, carB.name, true)
        val carBRound3 = SnapShot(round, carB.name, false)

        val carCRound1 = SnapShot(round, carC.name, false)
        val carCRound2 = SnapShot(round, carC.name, false)
        val carCRound3 = SnapShot(round, carC.name, false)

        val record = Record(
            listOf(
                carARound1, carARound2, carARound3,
                carBRound1, carBRound2, carBRound3,
                carCRound1, carCRound2, carCRound3
            )
        )

        // Act & Assert
        assertThat(listOf("A")).isEqualTo(Output.getWinnerCarName(record))
    }

    @Test
    fun `다수 우승자 차 이름 추출 성공`() {
        // Arrange
        val round = 3
        val carA = Car("A")
        val carB = Car("B")
        val carC = Car("C")

        val carARound1 = SnapShot(round, carA.name, true)
        val carARound2 = SnapShot(round, carA.name, true)
        val carARound3 = SnapShot(round, carA.name, true)

        val carBRound1 = SnapShot(round, carB.name, true)
        val carBRound2 = SnapShot(round, carB.name, true)
        val carBRound3 = SnapShot(round, carB.name, true)

        val carCRound1 = SnapShot(round, carC.name, false)
        val carCRound2 = SnapShot(round, carC.name, false)
        val carCRound3 = SnapShot(round, carC.name, false)

        val record = Record(
            listOf(
                carARound1, carARound2, carARound3,
                carBRound1, carBRound2, carBRound3,
                carCRound1, carCRound2, carCRound3
            )
        )

        // Act & Assert
        assertThat(listOf("A", "B")).isEqualTo(Output.getWinnerCarName(record))
    }
}
