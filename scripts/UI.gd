extends Node

@onready var computer_ui: Sprite2D = $UI/ComputerPopUp

func _on_computer_input_event(viewport, event, shape_idx):
	if event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
		show_computer()

func show_computer():
	computer_ui.visible = true
	set_physics_process(false) 
