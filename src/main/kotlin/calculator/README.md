##기능 요구 사항

사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.


### TO DO
1. 테스트 작성
   - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
   - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
   - 덧셈
   - 뺄셈
   - 곱셈
   - 나눗셈
   - 사칙 연산을 모두 포함
   - 음수 포함
   - 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
   - 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
   - 숫자가 아닐 경우 IllegalArgumentException throw
2. 기능 구현
3. 객체 지향스럽게 리팩토링

## 리뷰 반영
- [x] parseNumber 안의 계산 기능 분리하기
- [x] Operator.get 보다는 of 나 find 로 메소드 이름 바꾸기
- [x] Operator 테스트 분리