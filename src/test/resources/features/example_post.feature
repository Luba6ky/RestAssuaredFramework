Feature: Example API POST Request Testing

  Scenario: Create new post
    Given I have the POST endpoint "https://jsonplaceholder.typicode.com/posts"
    And I have the following post data
      | title | body | userId |
      | foo   | bar  | 1      |
    When I send a POST request to the endpoint with the post data
    Then the response status code should be 201
    And the response should contain the post data
