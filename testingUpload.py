import pyautogui
import subprocess
import time
import subprocess
import os
import random
######## Connect to server #############
pyautogui.moveTo(18, 43, duration=.5)  
pyautogui.click()
pyautogui.moveTo(24, 57, duration=.5)  
pyautogui.click()
pyautogui.moveTo(1034, 442, duration=.5)  
pyautogui.click()
pyautogui.write("123")
pyautogui.moveTo(722, 611, duration=.5)
pyautogui.click()
pyautogui.moveTo(1166, 704, duration=.5)
pyautogui.click()
########################################
time.sleep(3) # Wait for connection
for k in range(100):
    pyautogui.moveTo(217, 231, duration=.01) # Select File
    pyautogui.click()
    pyautogui.moveTo(444, 180, duration=.01) # Upload Selected
    pyautogui.click()
