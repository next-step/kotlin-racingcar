package domain.step2.domain

import domain.step2.domain.expression.Expression
import domain.step2.domain.expression.Operand
import domain.step2.domain.expression.Operator
import domain.step2.strategy.split.SplitStrategy

object Calculator {

    // 쪼갠 상태를 넣을까 고민했으나, 문자열 그대로 넣는것이 실세계와 비슷하다 생각해서 래퍼 클래스로 넘겼습니다.
    // object 로 싱글톤 클래스를 만들면 동반 객체를 만들지 못합니다 -> 매직 리터럴 관리를 따로 클래스로 관리해야할까요?
    fun calculate(expression: Expression, splitStrategy: SplitStrategy): Operand {
        val expressionWords = expression.split(splitStrategy)
        return expressionWords.subList(1, expressionWords.size).asSequence()
            .chunked(2)
            .map { Pair(Operator.values(it[0]), Operand(it[1])) }
            .fold(Operand(expressionWords[0])) { sum, monomial -> monomial.first.calculate(sum, monomial.second) }
    }
}
