@echo off
::set /a num1=25
::set /a ans=/num1//10
::set /a val=/ans/*10
::set /a dif=/num1/-/val/
::echo /dif/
::set /a girlfriend=1
::if /girlfriend/ == 1 (echo Tama ean) else (echo "Isa lang dapat kasi :<")
SET /p money="Enter your money>"
::if /wantawsan/ > 0
SET /a wantawsan=money/1000
SET /a paybhandred=(money-wantawsan*1000)/500
SET /a towhandred=(money-(wantawsan*1000)-(paybhandred*500))/200
SET /a wanhandred=(money-(wantawsan*1000)-(paybhandred*500)-(towhandred*200))/100
SET /a pipty=(money-(wantawsan*1000)-(paybhandred*500)-(towhandred*200)-(wanhandred*100))/50
SET /a bente=(money-(wantawsan*1000)-(paybhandred*500)-(towhandred*200)-(wanhandred*100)-(pipty*50))/20
SET /a sampu=(money-(wantawsan*1000)-(paybhandred*500)-(towhandred*200)-(wanhandred*100)-(pipty*50)-(bente*20))/10
SET /a payb=(money-(wantawsan*1000)-(paybhandred*500)-(towhandred*200)-(wanhandred*100)-(pipty*50)-(bente*20)-(sampu*10))/5
SET /a wan=(money-(wantawsan*1000)-(paybhandred*500)-(towhandred*200)-(wanhandred*100)-(pipty*50)-(bente*20)-(sampu*10)-(payb*5))/1
echo "1000 = %wantawsan%
echo "500 = %paybhandred%
echo "200 = %towhandred%
echo "100 = %wanhandred%
echo "50 = %pipty%
echo "20 = %bente%
echo "10 = %sampu%
echo "5 = %payb%
echo "1 = %wan%
