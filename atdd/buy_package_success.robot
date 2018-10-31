*** Settings ***
Library   SeleniumLibrary
#Test Teardown   Close Browser

*** Variables ***


*** Testcases ***
ซื้อประกันเดินทางภายในประเทศสำเร็จ
    กรอกข้อมูลลูกค้า
    เลือก package การเดินทางภายในประเทศ
    แสดงรายละเอียดการสั่งซื้อ
    เลือกช่องทางการชำระเงินด้วย credit cart/debit
    ยืนยันการสั่งซื้อ


*** Keywords ***
แสดงรายละเอียดการสั่งซื้อ
    แสดงชื่อ package ภายในประเทศ
    แสดงข้อมูลผู้ติดตาม  0 คน
    แสดง total price  40,000.00

เลือก package การเดินทางภายในประเทศ
    ต้องแสดง promotion จำนวน 2 รายการ
    เลือก promotion ที่ 1
    ไม่มีผู้ติดตาม

กรอกชื่อและนามสกุล
    [Arguments]  ${firstname}  ${lastname}
    Input Text   id:firstname  ${firstname}
    Input Text   id:lastname  ${lastname}

กรอกข้อมูลลูกค้า
    Open Browser
    ...  http://localhost:8080/demo/cust_info.jsp
    ...  browser=chrome
    กรอกชื่อและนามสกุล  Suwitchan  Chatprasert
    กรอกวันเกิด  09/04/1984
    กรอกหมายเลขบัตรประชาชน  3301800293587
    กรอกข้อมูลติดต่อ   pporroqq@gmail.com   0895244296



