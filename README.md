# SurvivorsGuide

1.9.6
	• Adding app version to saved character file
	• Checking character version before loading to ensure compatibility

1.9.5
	• Prod error: NullPointerException in CrossReferenceActivity.updateAvailableProfessions
		○ Handled null class property condition
	• Prod error: NullPointerException in SkillList.getSkillsByNameSetCost
		○ Reproduced with unit test
			§ Found / fixed other weakness in similar searching functions using unit tests
		○ Handles null parameter condition
	• Prod error: IndexOutOfBoundsException in CharacterEditExistingActivity.java:77
		○ Adding check of array size before assignment
	• Skill name fixes
	• Search functions updated to binary searches

1.9.4
	• App crashes due to StackOverflowError
		○ Traced to binary searches implemented in 1.9.3 list searching functions
		○ Reverted list search change

1.9.3
	• Changes to Profession & Strain lists which caused certain related items not to show
	• Implementing list binary searching
	• Additional unit tests

1.9.2
	• App crashes due to StackOverflowError
		○ Traced to binary searches implemented in 1.9.1 list searching functions
		○ Reverted list search change

1.9.1
	• Adds strain option to cross reference activity
	• Improve unit testing coverage
	• Improve list searching functionality by refactoring from brute force to binary
		○ Alphabetical positions compared using ascii values

1.9.0
	• Added option to delete a saved character
	• Improve unit tests

1.8.0
	• Open skills added to skills available to characters
	• Improved skill text

1.7.0
	• Update activity background image
	• Update item and popup background color
	• Reduce button code duplication
	• Added skill, profession and strain details

1.6.0
	• Fixing crash issue in cross reference activity

1.5.0
	• Improve unit tests
	• Improve readability
	• Update content

1.4.0
	• Added spent build
	• Added skill / profession cross reference

1.3.0
	• Improve edit character

1.2.0
	• Update to app icon

1.1.0
	• Improve UI text readability

1.0.0
Initial release to app store

Features:
-Character creation & modification
-Strain lookup
-Skill lookup
-Profession lookup

Upcoming Features:
-3rd Profession Support
-Skill tables
-Skill / Profession cross-reference lookup
-Add & Share descriptions

This app is intended for entertainment purposes only. It provides character management functionality for characters
created for the Dystopia Rising game: http://www.dystopiarisinglarp.com/
