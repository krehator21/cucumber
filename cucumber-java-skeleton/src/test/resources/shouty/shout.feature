Feature: Shout

  In order to send location-sensisitive messages to people nearby
  As a shouter
  I want to broadcast messages to people near me

  Rules:
    - broadcast to all users
    - don't worry about proximity yet

  To do:
    - only shout to people within a certain distance

  Background:
    Given a person named Lucy
    And a person named Sean

  Scenario: Listener hears a message
    When Sean shouts "free bagels!"
    Then Lucy hears Sean's message

    Scenario: Listener hears a different message
      When Sean shouts "free coffee"
      Then Lucy hears Sean's message

    Scenario: Listener is within range

    Scenario:  is out of range