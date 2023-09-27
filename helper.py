import pyautogui


from pynput import mouse


def on_click(x, y, button, pressed):
    print(pyautogui.position())
with mouse.Listener(on_click=on_click) as listener:
    try:
        listener.join()
    except:
        pass


