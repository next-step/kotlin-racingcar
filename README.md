# kotlin-racingcar

# 🚀 2단계 - 문자열 계산기

## 기능 요구사항
- [x] 사칙 연산 계산
  - [x] 연산자에 해당하는 계산기
    - [x] 덧셈
    - [x] 뺄셈
    - [x] 곱셈
    - [x] 나눗셈
      - [x] 0으로 나누려는 경우 연산하지 않는다.
      - [x] 소수점은 모두 무시한다.
- [x] 입력 순으로 계산 (연산 우선 순위 무시)

### 2단계 피드백
- [x] Application의 calculate 함수를 Calculator 클래스 내부로 이동
- [x] calculate 함수의 로컬 변수명 변경
  - inputFormula -> formula
- [x] calculateInternal 함수의 로컬 변수명 변경
  - summary -> total
- [x] Application 내부 메서드 순서 변경 (호출 순)
- [x] 불필요한 코드 제거 (map)
- [x] 연산기호 객체를 표현할 수 있는 클래스명으로 변경
  - Calculator -> Operator
- [x] Scanner 대신 readln 함수 사용
- [x] 함수에서 중괄호를 사용하는 경우 `return` 명시
- [x] scope function 대신 Elvis operator 활용!
- [x] 나누기 0 예외 처리를 operation 내부에서 수행하도록 변경
- [x] InputView를 object class로 변경
  - 자바의 private 생성자를 만들고, static 메서드로 명시하던 것과 비슷하다..

---

# 🚀 3단계 - 자동차 경주

## 기능 요구사항
- [x] 자동차의 대수와 이동 횟수를 입력받는다.
- [ ] 이동 횟수만큼 전진을 시도한다.
- [ ] 자동차
  - [ ] 자동차의 위치 
  - [ ] 전진 또는 멈춤
- [ ] 전진 조건
  - [ ] 0~9 사이의 무작위 값을 구한 후 4 이상일 경우
- [ ] 자동차의 위치를 화면에 출력
