package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RefereeTest {
	@Test
	fun `judge`() {
		val anna = RacingCar(moved = 1, generator = { 3 }, "Anna")
		val pobi = RacingCar(moved = 2, generator = { 3 }, "Pobi")
		val winnerNames = Referee(RacingCars(listOf(anna, pobi))).judge()
		Assertions.assertThat(winnerNames).isEqualTo(listOf("Pobi"))
	}

	@Test
	fun `judge multiple winner`() {
		val anna = RacingCar(moved = 2, generator = { 3 }, "Anna")
		val pobi = RacingCar(moved = 2, generator = { 3 }, "Pobi")
		val winnerNames = Referee(RacingCars(listOf(anna, pobi))).judge()
		Assertions.assertThat(winnerNames).isEqualTo(listOf("Anna", "Pobi"))
	}
}
