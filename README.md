Welcome to Czechbot, a Pokemon Showdown battle bot! Note: This is still very much a work in progress.

**What Czechbot Does**

The end goal of Czechbot is simple: beat a human player in a Pokemon battle. In the end, you should be able to start the 
bot, have it run through the entire Pokemon battle by itself, and hopefully win.

**Starting This Thing Up**

The program sets up a WebSocket connection to connect to the Pokemon Showdown server, then sends login information to
the Showdown server. I have a text file that is not shared on Git that is named <actually_private_data> that contains the
username and password to the bot's Showdown account. This username and password, as well as some identification details,
are sent to the Showdown servers, then a request for a generation 8 random battle. 

**How Czechbot Works**

The program creates an instance of the BattleState class with the user's and opponent's Pokemon and moves, and the Czechbot
algorithm (to be created) determines what the program should do based on moves available.