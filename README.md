# UofTorontopoly Monopoly Game

Are you a monopoly lover?

Or maybe it is your first time playing Monopoly?

Then this is one of the most exciting versions of Monopoly that you will ever play...
Let's introduce you with the ***University of Toronto themed Monopoly Game***, **UofTorontopoly**! 

This is exactly the right game for you if you are a current UofT student, or maybe an alumni,
or a professor at UofT, or a future student that is planning to apply
to UofT. This Monopoly game is based on all the locations
that you might be familiar with on the UofT campus. Enjoy the game,
refresh your memories of UofT while playing, and buy all your
best study locations of UofT on the UofTorontopoly Game!


***Creators:***

*Alphabetical order according to last names.*

* Xinyan Lyu
* Maria Mustard
* Sinem Soylemezoglu
* Kamran Takesh
* Adeline Wang
* Celina Yueh
* Yang Zhenze

*Our Mission*

Implementing an original University of Toronto themed Monopoly Game,
based on Clean Architecture Design Patterns and Solid Principles.

## Things to Remember Before Starting to Play:
- [ ] First things first, please read the UofTorontopoly Manual.
- [ ] Verify that you are playing between 2-8 players.
- [ ] Please create a username for each player.
- [ ] All the players wil be initiated with a fixed amount of Monopoly cash at the start of the game.
- [ ] Each player will have consecutive turns, set at the start of the game.
- [ ] For the rest of the game rules and how to play, please refer to the UofTorontopoly Manual below.

**Work in progress, not the final version.**  

## UofTorontopoly Manual

***Contents:***

- A monopoly gameboard catered to the University of Toronto.
- Beneath the game board displays the players cards. This will 
include the player's property cards, etc...
- Beside the gameboard and player cards is a command line where you will see instructions on what to do and your 
responses will also be typed in this commandline.
- The default campaign will include 32 tiles, 5 Community Chest cards, 5 Chance cards, a package of Properties, 2 Dice

***Money:***

Each player starts with 1000 Tbucks. It is up to the player what they want to do with it.

***Game Rules:***

1. The first player who joins the game, Player 0, will start the game first. Player 0 shall roll both of the dice.
   Starting at the corner tile labeled, 'START' player 0 will advance the amount of tiles as the 2 dice combined. After

2. Player 0 has completed their play, the turn is now to the player on the left. The next player will repeat what
   player 0 did in rule 1. Note that players can land on the same tiles and rest on the same tiles as other players.

3. According to the space which the player lands on, the player may be entitled to buy property, pay rent to an already
   purchased property, collect chance/community chest card, go to jail, etc...

4. Everytime a player land on or passes the original START tile, the player get to collect 100 tbucks.

5. If the player lands on a property and needs to pay rent that they can not afford, then they are bankrupt and out of
   the game. If the player lands on a property to draw a card, and the card is a LoseCashCard, and the player has
   insufficent funds, then the player is bankrupt and out of the game.

6. The goal of the game is to be the last player in the game that does not go bankrupt.

7. Last and most important rule is to have fun! Enjoy buying/selling/trading your favourite or least favourite
   places at the University of Toronto!!
   
***Game Commands:***
   
To perform any actions, the players must write the following commands into the command line, corresponding to an action.

Saving/Starting a Game:
"read_campaign": Read from a save file to resume a game.
"start_default_campaign": Start a new campaign.

Before A Player Moves:
"save_campaign": Save the current campaign.
"roll": Roll the dice for the current player.

Buy Land:
"yes": Confirm buy land
"no": Decline buy land

After a turn:
"end_turn": End the cirrent player's turn and move to the next.
