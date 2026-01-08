extends CanvasLayer

func fade_to(scene_path: String):
	var tween = create_tween()
	tween.tween_property($ColorRect, "modulate:a", 1.0, 0.5)
	await tween.finished
	get_tree().change_scene_to_file(scene_path)
	tween = create_tween()
	tween.tween_property($ColorRect, "modulate:a", 0.0, 0.5)
