import requests

# Specify the URL
url = 'http://137.112.104.167:5000'

# Making a GET request
response = requests.get(url)

# Checking the status code of the request
if response.status_code == 200:
    print('Success:', response.text)
else:
    print('Failed:', response.status_code)
