*** Settings ***
Library   Selenium2Library
Test Teardown   Close Browser

*** Testcases ***
Login success with somkiat
  เข้าหน้า login
  กรอก username และ password
  สามารถเข้าระบบงานได้

*** Keywords ***
สามารถเข้าระบบงานได้
  Wait Until Page Contains    สวัสดีจ๊ะ

กรอก username และ password
  Input Text  id=user   demo
  Input Text  id=pin   pass
  Click Button   เข้าสิจ๊ะ

เข้าหน้า login
  Open Browser   http://localhost:8082/demo/
  ...  browser=chrome
  ...  remote_url=http://localhost:4444/wd/hub
  ...  desired_capabilities=browserName:chrome,platform:MAC,platformName:MAC
