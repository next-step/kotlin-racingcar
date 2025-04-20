@file:Suppress("ktlint:standard:no-wildcard-imports")

package carracing.game.controller

import carracing.game.domain.data.Car
import carracing.game.domain.data.Race
import carracing.game.view.CarRacingView
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

class RaceControllerTest {
    private val carRacingView = mock<CarRacingView>()
    private val race = mock<Race> { on { generateRaceSequence() } doReturn emptySequence() }

    private lateinit var controller: RaceController

    @BeforeEach
    fun init() {
        controller =
            RaceController(
                race = race,
                carRacingView = carRacingView,
            )
    }

    @Test
    fun `when start race invoke should show current state`() {
        val raceSequence = sequenceOf(race, race, race)
        whenever(race.generateRaceSequence()).thenReturn(raceSequence)

        controller.startRace()

        verify(race).generateRaceSequence()
        verify(carRacingView, times(3)).printCurrentRaceState(any())
    }

    @Test
    fun `when race ends should show winners`() {
        val winner = Car(1, "car") { 1 }
        val raceSequence = sequenceOf(race)
        whenever(race.generateRaceSequence()).thenReturn(raceSequence)
        whenever(race.winners).thenReturn(listOf(winner))

        controller.startRace()

        verify(carRacingView).printWinners(listOf(winner.name))
    }
}
