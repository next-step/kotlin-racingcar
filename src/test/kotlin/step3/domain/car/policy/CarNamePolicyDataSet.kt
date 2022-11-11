package step3.domain.car.policy

class CarNamePolicyDataSet {

    companion object {

        fun randomCarName(length: Int): String = buildString {

            repeat(length) {
                append(randomCharacter())
            }
        }

        fun randomValidCarName(): String = (100 downTo 1).asSequence()
            .map { randomCarName(it) }
            .filter { DefaultCarNamePolicy.isValidName(it) }
            .first()

        private fun randomCharacter(): Char = (('a'..'z') + ('A'..'Z')).random()
    }
}