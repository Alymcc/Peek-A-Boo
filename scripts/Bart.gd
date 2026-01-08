extends Node

func on_interact():
	Dialogue.start_dialogue([
		"Oh, you found me.",
		"Thanks… I was trying to avoid the party.",
		"I'm worried people won’t like me… AND Caster said he was thirsty."
		], null, func():
			Global.bartholomew_found = true
			Global.bartholomew_at_couch = true
			Transition.fade_to("res://scene/CouchArea.tscn")
			)
			
func _input_event(viewport, event, shape_idx):
	if event is InputEventMouseButton and event.pressed:
		on_interact()
