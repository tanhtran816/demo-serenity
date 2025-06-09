@vnexpress
Feature: Search VNExpress for Korea News
  As a user
  I want to search for Korea-related news on VNExpress
  So that I can read the latest updates

  Scenario: Search for North Korea news and verify South Korea mention
    Given Nam can browse the web
    When he opens Google homepage
    And he searches for "VNExpress" on Google
    And he clicks on VNExpress website
    And he navigates to "Thời sự" section
    And he scrolls down 2 times
    And he opens search function
    And he searches for "Triều Tiên" on VNExpress
#    And he clicks on the first article/
    Then he should see "Triều Tiên" mentioned in the article