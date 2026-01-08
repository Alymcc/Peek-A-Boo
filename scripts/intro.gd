extends CanvasLayer

@onready var img = $TextureRect

func _ready():
	var tween = create_tween()
	tween.tween_property(img, "modulate:a", 1.0, 1.0)
	await tween.finished
	await get_tree().create_timer(1.0).timeout

	tween = create_tween()
	tween.tween_property(img, "modulate:a", 0.0, 1.0)
	await tween.finished
	get_tree().change_scene_to_file("res://scene/main_menu.tscn")
