Welcome to Czechbot, a Pokemon Showdown battle bot! Note: Unfortunately, I have been forced to stop work on Czechbot. Czechbot works by 
taking in data from various sources, including a website called Pokemon Showdown, and the complete database comes from Pokemon Showdown. 
Pokemon Showdown is created in JavaScript, and therefore the data for the different Pokemon moves and abilities is in TypeScript. However,
the work I have done on Czechbot is in Java. There is a partial JSON database online for the moves, but it does not have everything I need
and no such database exists for the abilities. So I have two choices: either hard code every possible move and ability into my code from scratch
(there are hundreds of each) or scrap the project, and I have chosen to scrap the project.

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
