@echo off
:qa1
SET /p q1=Enter your 1st Quarter ave:
:qa2
SET /p q2=Enter your 2nd Quarter ave:
:qa3
SET /p q3=Enter your 3rd Quarter ave:
:qa4
SET /p q4=Enter your 4th Quarter ave:
SET /a ave=(%q1%+%q2%+%q3%+%q1%)/4
::if %ave% GEQ 101 echo Invalid ave!
::if %ave% LEQ 49 
if %q1% 50 (
GOTO :qa1
)
echo Your average is %ave%
echo Remarks:
::100 Above
if %ave% GEQ 101 (
echo Invalid input
)
::Grade 95 to 100
if %ave% GEQ 95 (
if %ave% LSS 100 (
echo Outstanding 
)
)
::Grade 90 to 94
if %ave% GEQ 90 (
if %ave% LSS 94 (
echo Very Good 
)
) 
::Grade 85 to 89
if %ave% GEQ 85 (
if %ave% LSS 89 (
echo Good 
)
)
::Grade 80 to 84
if %ave% GEQ 80 (
if %ave% LSS 84 (
echo Satisfactory 
)
)
::Grade 75 to 79
if %ave% GEQ 75 (
if %ave% LSS 79 (
echo Poor 
)
)
::Grade 50 to 74 
if %ave% LEQ 74 (
if %ave% GEQ 50 (
echo Failed 
)
)
::Grade 50 Below
if %ave% LSS 50 (
echo Invalid Input
)
​
