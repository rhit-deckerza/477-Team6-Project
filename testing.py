import pyautogui
import subprocess
 
 
# If your shell script has shebang,
# you can omit shell=True argument.
process = subprocess.Popen(["connectToServer.sh"], shell=True)
# pyautogui.FAILSAFE = True
# # Move mouse to X=500, Y=500 screen coordinates
pyautogui.moveTo(18, 43, duration=1)  # duration specifies the time to move to this position
pyautogui.click()
pyautogui.moveTo(24, 57, duration=.5)  # duration specifies the time to move to this position
pyautogui.click()
pyautogui.moveTo(1034, 442, duration=1)  # duration specifies the time to move to this position
pyautogui.click()
pyautogui.write("123")
pyautogui.moveTo(722, 611, duration=1)
pyautogui.click()
pyautogui.moveTo(1166, 704, duration=1)
pyautogui.click()
# process.terminate()
# # Type a string
# pyautogui.write("Hello, world!")

# # Press a key (e.g., 'f1', 'ctrl', 'alt', etc.)
# pyautogui.press('f1')

# # Combination of keys
# pyautogui.hotkey('ctrl', 'c')