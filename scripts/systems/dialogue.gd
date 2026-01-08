extends CanvasLayer

var lines: Array[String] = []
var index := 0
var callback: Callable = Callable()

func start_dialogue(new_lines: Array[String], _portrait: Texture2D = null, finished_callback: Callable = Callable()):

	lines = new_lines
	index = 0
	callback = finished_callback
	$Panel.visible = true
	$Panel/Label.text = lines[index]

func _input(event):
	if event.is_action_pressed("interact") and $Panel.visible:
		index += 1
		if index >= lines.size():
			$Panel.visible = false
			if callback:
				callback.call()
			else:
				$Panel/Label.text = lines[index]
