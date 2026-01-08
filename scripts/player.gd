extends CharacterBody2D

var character_direction : Vector2
var character_speed := 3000.0
@onready var animated_sprite_2d: AnimatedSprite2D = $AnimatedSprite2D
var margin = 8.0
@onready var computer_popup = $"../UI/ComputerPopUp"
@onready var file_viewer = $"../UI/FileViewer" 
@export var folder_images: Array[Texture2D] = [] # Drag your PNGs into this in the Inspector
var current_page = 0
var washroom_unlocked = false
var correct_code = "1259"
@onready var keypad_image = $"../UI/KeyPadUI/KeyPadImg" 
@onready var keypad_ui = $"../UI/KeyPadUI" 
@onready var code_input = $"../UI/KeyPadUI/code" 


func _physics_process(delta: float) -> void:
	if Input.is_action_pressed("left") or Input.is_action_pressed("right") or Input.is_action_pressed("down") or Input.is_action_pressed("up"):
		character_direction.x = Input.get_axis("left","right")
		character_direction.y = Input.get_axis("up","down")
		character_direction = character_direction.normalized()
		
		if character_direction.x < 0 && character_direction.y ==0:
			animated_sprite_2d.animation ="walk_left"
		if character_direction.x > 0 && character_direction.y ==0:
			animated_sprite_2d.animation ="walk_right"
		if character_direction.y < 0:
			animated_sprite_2d.animation ="walk_up"
		if character_direction.y > 0:
			animated_sprite_2d.animation ="walk_down"
		
		velocity = character_direction * character_speed * delta
	else:
		velocity =Vector2(0, 0)
		
		if animated_sprite_2d.animation =="walk_left":
			animated_sprite_2d.animation ="idle_left"
		if animated_sprite_2d.animation =="walk_right":
			animated_sprite_2d.animation ="idle_right"
		if animated_sprite_2d.animation =="walk_up":
			animated_sprite_2d.animation ="idle_up"
		if animated_sprite_2d.animation =="walk_down":
			animated_sprite_2d.animation ="idle_down"
	
	move_and_slide()
	

	position.x = clamp(position.x, -255 + margin, 255 - margin)
	position.y = clamp(position.y, -400 + margin, 400 - margin)


func _on_computer_input_event(viewport: Node, event: InputEvent, shape_idx: int) -> void:
	if event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
		$"../UI/ComputerPopUp".visible = !$"../UI/ComputerPopUp".visible

func _on_computer_pop_up_gui_input(event: InputEvent) -> void:
	if event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
		$"../UI/ComputerPopUp".visible = false

func _on_file_folder_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
		open_folder()

func open_folder():
	if folder_images.size() > 0:
		current_page = 0
		show_page(0)
		file_viewer.visible = true

func show_page(index):
	file_viewer.texture = folder_images[index]

func _on_file_viewer_gui_input(event):
	if event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
		current_page += 1
		
		if current_page < folder_images.size():
			show_page(current_page)
		else:
			file_viewer.visible = false
			current_page = 0

func _on_washroom_trigger_body_entered(body: Node2D) -> void:
	print("1. Trigger touched by: ", body.name)
	if body.name == "player" and not washroom_unlocked:
		print("2. Player detected. Is it unlocked? ", washroom_unlocked)
		# Freeze player movement and show keypad
		set_physics_process(false) 
		keypad_ui.visible = true
		code_input.grab_focus()
		print("Keypad is visible and text box is ready for typing.")

func _on_line_edit_text_submitted(new_text: String) -> void:
	print("User pressed Enter. Code entered: ", new_text)
	# Check the code immediately
	_on_submit_button_pressed() 

func _on_submit_button_pressed() -> void:
	if code_input.text == correct_code:
		washroom_unlocked = true
		print("3. Showing Keypad UI now.")
		keypad_ui.visible = false
		set_physics_process(true) # Let player move again
		print("Unlocked!")
	else:
		print("Wrong code!")
		code_input.text = "" # Clear it to try again

func _on_keypad_image_gui_input(event: InputEvent) -> void:
	# For now, clicking the image will "unlock" it
	if event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
		print("4. Click detected on the Keypad Image!")
		washroom_unlocked = true
		keypad_image.visible = false
		print("Washroom is now permanently unlocked!")
