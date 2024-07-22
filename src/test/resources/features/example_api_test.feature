Feature: Example API GET Request Testing

  Scenario: Get post details
    Given I have the endpoint "https://jsonplaceholder.typicode.com/posts/1"
    When I send a GET request to the endpoint
    Then the response userId should be 1
    And the response id should be 1
    And the response title should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
