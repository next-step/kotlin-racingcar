package racing.domain

import racing.domain.utils.RandomNumberStrategy

class FixtureBuilder {

    companion object {
        class RandomNumberFixture(private val number: Int) : RandomNumberStrategy {
            override fun getRandomNumber(): Int {
                return number
            }
        }
    }
}
