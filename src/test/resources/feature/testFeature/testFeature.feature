Feature: testFeature

    As a user, I can enter my guess into the hangman app, so that I can be entertained.

    Scenario Outline: Guesses
        When I enter <guess>  into the guess box
        Then <response> should be given to me as an oldGuess

        Examples:
            | guess     | response  |
            | c         | c         |
