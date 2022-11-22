package step3.domain.car.name

import step3.domain.game.RacingGame

private val characterList: List<Char> =
    ('a'..'z') + ('A'..'Z') + ('0'..'9') + listOf('-', '_', '@', '#', '$', '%', '&')

class CarNameDataSet {
    companion object {
        fun testData(): String = testData((1..CarName.MAX_CAR_NAME_LENGTH).random())

        fun testData(length: Int): String {
            require(length > 0) { "length must be greater than zero" }

            return buildString {
                repeat(length) {
                    append(randomCharacter())
                }
            }
        }

        fun testDataList(size: Int = RacingGame.DEFAULT_TOTAL_CAR_COUNT): List<String> = (1..size).map { testData() }

        private fun randomCharacter(): Char = characterList.random()
    }
}
