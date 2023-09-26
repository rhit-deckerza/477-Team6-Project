import pyautogui
from pynput import mouse

def on_click(x, y, button, pressed):
    if pressed:
        print(f'X: {x}, Y: {y}')

# Start listening to mouse events
with mouse.Listener(on_click=on_click) as listener:
    listener.join()