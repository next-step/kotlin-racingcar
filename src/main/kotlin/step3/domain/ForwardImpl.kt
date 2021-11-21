package step3.domain

import kotlin.random.Random

/**
 *
 * @author Leo
 */
class ForwardImpl : Forward {

    override fun moved() = Random.nextInt(10) >= 4
}
