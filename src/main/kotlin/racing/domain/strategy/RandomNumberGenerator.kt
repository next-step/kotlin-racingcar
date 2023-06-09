package racing.domain.strategy

import java.util.concurrent.ThreadLocalRandom

object RandomNumberGenerator : Generator<Int> {
    private const val THRESHOLD = 10

    override fun generate(): Int = ThreadLocalRandom.current().nextInt(THRESHOLD)
}
