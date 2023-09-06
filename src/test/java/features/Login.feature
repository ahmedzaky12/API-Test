@PETTSK
Feature: test login scenario
  Scenario Outline: Login to the Pet Store
    Given I navigate to the Pet Store
    When I login using valid credentials "<username>" and "<password>"
    Then I should get a correct response "<username>" and "<password>"

    Examples:
      | username | password |
      | Zaki    | test     |

