import os

PLAYER_ONE = "PLAYER 1"
PLAYER_TWO = "PLAYER 2"
COMMANDS = [
	"Paper"	,	# Win Against: Spock and Rock (+1 and +2)
	"Spock"	,	# Win Against: Rock and Scissor (+1 and +2)
	"Rock"	,	# Win Against: Scissor and Lizard (+1 and +2)
	"Scissor",	# Win Against: Lizard and Paper (+1 and +2)
	"Lizard",	# Win Against: Paper and Spock (+1 and +2)
	"Paper", "Spock"]

def display_main_menu():
	print('Welcome to Bazinga!')
	print('Choose one of the following options:')
	print('(1) - Start a Game!')
	print('(2) - How To Play?')
	print('(0) - Exit The Game')

def receive_main_menu_option():
	command = input()
	if command == 1:
		command = 1
	elif command == 2:
		command = 2
	elif command == 0:
		command = 0
	else:
		print('Unknown command! Please choose again.')
		command = -1
		raw_input("Press enter to continue.")
	os.system('clear')
	return command

def main_menu():
	display_main_menu()
	main_option = receive_main_menu_option()
	
	while(main_option == -1):
		display_main_menu()
		main_option = receive_main_menu_option()

	if main_option == 1:
		choices_menu()
	elif main_option == 2:
		instructions_menu()
	else:
		exit_bazinga()

def choices_menu():
	player_one = -1
	while(player_one == -1):
		display_choices_menu(PLAYER_ONE)
		player_one = receive_action()
		if player_one == 10:
			main_menu()
	
	player_two = -1
	while(player_two == -1):
		display_choices_menu(PLAYER_TWO)
		player_two = receive_action()
		if player_two == 10:
			main_menu()

	winner = get_winner(player_one, player_two)
	display_winner(winner, PLAYER_ONE, PLAYER_TWO)
	main_menu()

def display_choices_menu(player_name):
	print("Hello " + player_name + "! Choose your action:")
	print('(1) - Paper')
	print('(2) - Spock')
	print('(3) - Rock')
	print('(4) - Scissors')
	print('(5) - Lizard')
	print('(0) - Forfeit')

def receive_action():
	action = input()
	if action == 1:
		action = 0
	elif action == 2:
		action = 1
	elif action == 3:
		action = 2
	elif action == 4:
		action = 3
	elif action == 5:
		action = 4
	elif action == 0:
		action = 10
	else:
		print('Unknown command! Please choose again.')
		action = -1
		raw_input("Press enter to continue.")
	os.system('clear')
	return action

def get_winner(action_one, action_two):
	if action_one == action_two:
		return 0
	elif COMMANDS[action_two] == COMMANDS[action_one + 1] or COMMANDS[action_two] == COMMANDS[action_one + 2]:
		return 1
	else:
		return 2

def display_winner(winner_player, player_one_name, player_two_name):
	if winner_player == 0:
		print("DRAW!")
	elif winner_player == 1:
		print(player_one_name + " won against " + player_two_name)
	else:
		print(player_two_name + " won against " + player_one_name)
	raw_input("Press enter to continue.")
	os.system('clear')

def instructions_menu():
	print("Bazinga is similar to Jo-Ken-Po, or Rock-Scissor-Paper.")
	print("But, instead of 3 possible actions, the game have 5.")
	print("The 5 possible actions are: ")
	print("1. Paper, which: ")
	print("\t disproves Spock; (Win against Spock)")
	print("\t covers Rock; (Win against Rock)")
	print("2. Spock, which: ")
	print("\t vaporizes Rock; (Win against Rock)")
	print("\t smashes Scissors; (Win against Scissors)")
	print("3. Rock, which: ")
	print("\t crushes Scissors; (Win against Scissors)")
	print("\t crushes Lizard; (Win against Lizard)")
	print("4. Scissors, which: ")
	print("\t decapitates Lizard; (Win against Lizard)")
	print("\t cuts Paper; (Win against Paper)")
	print("5. Lizard, which: ")
	print("\t eats Paper; (Win against Paper)")
	print("\t poisons Spock; (Win against Spock)")
	raw_input("Press enter to return to the main menu.")
	os.system('clear')
	main_menu()

def exit_bazinga():
	print("Goodbye! May the force be with you!")
