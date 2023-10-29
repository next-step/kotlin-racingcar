Feature: RacingCar Game

  Scenario Outline: 모든 자동차가 같은 조건일 때 우승자는 모든 자동차이다
    Given 자동차 이름 "<CarName1>","<CarName2>","<CarName3>"를 입력하고
    And 시도할 횟수 <회수>회를 입력하고
    And 모든 자동차가 전진조건이 고정 <조건>라고 가정하고
    And 우승자를 저장한다면
    When 게임을 진행한다
    Then 모든 자동차는 우승자이며 <이동거리>만큼 전진한다


    Examples:
      | CarName1 | CarName2 | CarName3 | 회수 | 조건 | 이동거리 |
      | pobi     | crong    | poror    | 5  | 4  | 5    |
      | jk       | kg       | sun      | 4  | 3  | 0    |

  Scenario Outline: 모든 자동차가 다른 조건일 때 우승자는 제일 앞에 있는 자동차다
    Given 자동차 이름 "<CarName1>","<CarName2>","<CarName3>"를 입력하고
    And 시도할 횟수 <회수>회를 입력하고
    And "<CarName1>"는 전진조건이 <조건1>이고 "<CarName2>"는 전진조건이 <조건2>이며 "<CarName3>"는 전진조건이 <조건3>라고 가정하고
    And 우승자를 저장한다면
    When 게임을 진행한다
    Then 우승자는 "<우승자>"이며 <이동거리>만큼 전진한다

    Examples:
      | CarName1 | CarName2 | CarName3 | 회수 | 조건1 | 조건2 | 조건3 | 우승자        | 이동거리 |
      | pobi     | crong    | poror    | 5  | 4   | 3   | 5   | pobi,poror | 5    |
      | jk       | kg       | sun      | 4  | 3   | 4   | 5   | kg,sun     | 4    |
      | jk       | kg       | sun      | 4  | 4   | 3   | 3   | jk         | 4    |
