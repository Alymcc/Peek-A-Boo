extends Node2D

@onready var music = $AudioStreamPlayer2D

func _ready():
	music.play()

func _on_start_pressed():
	get_tree().change_scene_to_file("res://scene/main.tscn")
