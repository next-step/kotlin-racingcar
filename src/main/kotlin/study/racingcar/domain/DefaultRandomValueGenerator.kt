package study.racingcar.domain

class DefaultRandomValueGenerator : RandomValueGenerator {
    override fun invoke(): Int = (0..9).random()
}
