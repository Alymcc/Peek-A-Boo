extends Node

func _ready():
	$Bartholomew.visible = Global.bartholomew_at_couch

	Dialogue.start_dialogue([
		"1 found, 4 to go.",
        "I should check the party room next."
	], null, func():
		Transition.fade_to("res://scene/main.tscn")
	)
