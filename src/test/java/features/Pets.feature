@PETTSK
Feature: validates pets
  Scenario Outline: Validate pet creation
    Given i create pet with name "<name>" and "<id>"
    Then i sohould validate correct response "<name>"
    Examples:
    |name|id|
    |cat |12|


    Scenario Outline: validate pet update
      Given i create pet with name "<name>" and "<id>"
      When i sohould validate correct response "<name>"
      And i update pet name to "<updatedName>"
      Then i should validate new name "<updatedName>"
      Examples:
        |name|updatedName|id|
        |cat |dog        |13|

      Scenario Outline: Delete Pet
        When i delete this pet "<id>"
        Then i should be deleted successfully "<id>"
        Examples:
          |id|
          |1|


