package carracing.model.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SnapshotTest {

    companion object {
        private const val NUMBER_OF_ITERATION = 4
        private fun getDummyCarTrace() = "----"
        private fun getDummyCarTraces() = List<CarTrace>(NUMBER_OF_ITERATION) { getDummyCarTrace() }
        private fun getDummySnapshotString() = "----\n".repeat(NUMBER_OF_ITERATION)
    }

    @Test
    fun `constructor - if 'carTraces' is an empty list, throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> { Snapshot(carTraces = listOf<CarTrace>()) }
    }

    @Test
    fun `toString - make 'carTraces' a string`() {
        val carTraces = getDummyCarTraces()
        val snapshot = Snapshot(carTraces)

        val snapShotString = snapshot.toString()

        assertEquals(getDummySnapshotString(), snapShotString)
    }
}
