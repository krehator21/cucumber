# language: no
Egenskap: Shout

  In order to send location-sensisitive messages to people nearby
  As a shouter
  I want to broadcast messages to people near me

  Rules:
  - broadcast to all users
  - don't worry about proximity yet

  To do:
  - only shout to people within a certain distance

  Bakgrunn:
    Gitt a person named Lucy
    Og a person named Sean

  Scenario: Listener hears a message
    Når Sean shouts "free bagels!"
    Så Lucy hears Sean's message

  Scenario: Listener hears a different message
    Når Sean shouts "free coffee"
    Så Lucy hears Sean's message

  Scenario: Listener is within range

  Scenario:  is out of range